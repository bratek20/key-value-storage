package pl.bratek20.keyvaluestorage.impl.infra.data;

import lombok.RequiredArgsConstructor;
import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValuePair;
import pl.bratek20.keyvaluestorage.api.Value;
import pl.bratek20.keyvaluestorage.impl.logic.KeyValueRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class KeyValueRepositoryImpl implements KeyValueRepository {
    private final KeyValuePairEntityRepository repository;

    @Override
    public List<KeyValuePair> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
            .map(KeyValuePairEntity::toApi)
            .toList();
    }

    @Override
    public Optional<Value> findValue(Key key) {
        return repository.findByKeyStr(key.value())
            .map(KeyValuePairEntity::toApi)
            .map(KeyValuePair::value);
    }

    @Override
    public void save(KeyValuePair keyValuePair) {
        var entity = repository.findByKeyStr(keyValuePair.key().value())
            .orElse(new KeyValuePairEntity(keyValuePair));

        entity.setValueStr(keyValuePair.value().value());
        repository.save(entity);
    }
}
