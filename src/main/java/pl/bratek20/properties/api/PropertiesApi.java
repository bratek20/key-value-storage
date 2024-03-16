package pl.bratek20.properties.api;

import java.util.List;

public interface PropertiesApi {
    <T> T get(PropertyName propertyName, Class<T> propertyType);
    <T> List<T> getList(PropertyName propertyName, Class<T> propertyType);
}
