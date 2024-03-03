package pl.bratek20.properties.impl;

import pl.bratek20.properties.api.PropertiesApi;
import pl.bratek20.properties.api.PropertiesSource;
import pl.bratek20.properties.api.PropertiesSourceName;
import pl.bratek20.properties.api.PropertyName;

import java.util.List;

public class PropertiesImpl implements PropertiesApi {
    private final List<PropertiesSource> sources;

    public PropertiesImpl(List<PropertiesSource> sources) {
        this.sources = sources;
    }

    @Override
    public <T> T get(PropertiesSourceName sourceName, PropertyName propertyName, Class<T> propertyType) {
        return sources.get(0).get(propertyName, propertyType);
    }
}