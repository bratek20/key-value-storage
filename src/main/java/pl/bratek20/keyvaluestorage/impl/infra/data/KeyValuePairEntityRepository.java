package pl.bratek20.keyvaluestorage.impl.infra.data;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KeyValuePairEntityRepository extends CrudRepository<KeyValuePairEntity, Long>{
    Optional<KeyValuePairEntity> findByKeyStr(String key);
}
