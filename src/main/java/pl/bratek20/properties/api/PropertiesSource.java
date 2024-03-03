package pl.bratek20.properties.api;

public interface PropertiesSource {
    PropertiesSourceName getName();

    <T> T get(PropertyName name, Class<T> type);
}