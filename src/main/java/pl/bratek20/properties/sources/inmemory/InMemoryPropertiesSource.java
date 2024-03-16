package pl.bratek20.properties.sources.inmemory;

import lombok.RequiredArgsConstructor;
import pl.bratek20.properties.api.PropertiesSource;
import pl.bratek20.properties.api.PropertiesSourceName;
import pl.bratek20.properties.api.PropertyName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class InMemoryPropertiesSource implements PropertiesSource {
    private final String name;
    private final Map<PropertyName, Object> properties = new HashMap<>();

    @Override
    public PropertiesSourceName getName() {
        return new PropertiesSourceName(name);
    }

    @Override
    public <T> T get(PropertyName name, Class<T> type) {
        return type.cast(properties.get(name));
    }

    @Override
    public <T> List<T> getList(PropertyName name, Class<T> type) {
        var property = properties.get(name);
        return (List<T>) property;
    }

    @Override
    public <T> boolean hasOfType(PropertyName name, Class<T> type) {
        var property = properties.get(name);
        return type.isInstance(property);
    }

    public void set(PropertyName name, Object property) {
        properties.put(name, property);
    }
}
