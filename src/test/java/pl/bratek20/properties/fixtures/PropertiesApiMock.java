package pl.bratek20.properties.fixtures;

import pl.bratek20.properties.api.PropertiesApi;
import pl.bratek20.properties.api.PropertyName;
import pl.bratek20.properties.impl.PropertiesImpl;
import pl.bratek20.properties.sources.inmemory.InMemoryPropertiesSource;

import java.util.List;

public class PropertiesApiMock implements PropertiesApi {
    private final InMemoryPropertiesSource source;
    private final PropertiesApi api;

    public PropertiesApiMock() {
        source = new InMemoryPropertiesSource("mock");
        api = new PropertiesImpl(List.of(source));
    }

    @Override
    public <T> T get(PropertyName propertyName, Class<T> propertyType) {
        return api.get(propertyName, propertyType);
    }

    @Override
    public <T> List<T> getList(PropertyName propertyName, Class<T> propertyType) {
        return api.getList(propertyName, propertyType);
    }

    public void setProperty(PropertyName propertyName, Object value) {
        source.set(propertyName, value);
    }
}
