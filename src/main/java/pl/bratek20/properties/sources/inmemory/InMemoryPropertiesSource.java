package pl.bratek20.properties.sources.inmemory;

import lombok.RequiredArgsConstructor;
import pl.bratek20.properties.api.PropertiesSource;
import pl.bratek20.properties.api.PropertiesSourceName;
import pl.bratek20.properties.api.PropertyName;

@RequiredArgsConstructor
public class InMemoryPropertiesSource implements PropertiesSource {
    private final String name;
    private Object property;

    @Override
    public PropertiesSourceName getName() {
        return new PropertiesSourceName(name);
    }

    @Override
    public <T> T get(PropertyName name, Class<T> type) {
        return type.cast(property);
    }

    public void set(PropertyName name, Object property) {
        this.property = property;
    }
}
