package pl.bratek20.properties.api;

import java.util.List;

public interface PropertiesSource {
    PropertiesSourceName getName();

    <T> T get(PropertyName name, Class<T> type);

    <T> List<T> getList(PropertyName name, Class<T> type);

    <T> boolean hasOfType(PropertyName name, Class<T> type);
}
