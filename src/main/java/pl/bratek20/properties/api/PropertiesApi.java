package pl.bratek20.properties.api;

public interface PropertiesApi {
    <T> T get(PropertiesSourceName sourceName, PropertyName propertyName, Class<T> propertyType);
}
