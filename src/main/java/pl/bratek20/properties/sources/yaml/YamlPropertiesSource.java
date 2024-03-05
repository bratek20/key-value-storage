package pl.bratek20.properties.sources.yaml;

import pl.bratek20.properties.api.PropertiesSource;
import pl.bratek20.properties.api.PropertiesSourceName;
import pl.bratek20.properties.api.PropertyName;

public class YamlPropertiesSource implements PropertiesSource {
    @Override
    public PropertiesSourceName getName() {
        return new PropertiesSourceName("yaml");
    }

    @Override
    public <T> T get(PropertyName name, Class<T> type) {
        return null;
    }

    @Override
    public <T> boolean hasOfType(PropertyName name, Class<T> type) {
        return false;
    }
}
