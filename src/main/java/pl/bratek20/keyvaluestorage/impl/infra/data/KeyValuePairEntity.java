package pl.bratek20.keyvaluestorage.impl.infra.data;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValuePair;
import pl.bratek20.keyvaluestorage.api.Value;

@Table(name = "key_value_pair", schema = "key_value_storage")
@NoArgsConstructor
public class KeyValuePairEntity {
    @Id
    private Long id;
    private String keyStr;
    @Setter
    private String valueStr;

    public KeyValuePairEntity(KeyValuePair api) {
        this.keyStr = api.key().value();
        this.valueStr = api.value().value();
    }

    public KeyValuePair toApi() {
        return new KeyValuePair(new Key(keyStr), new Value(valueStr));
    }
}
