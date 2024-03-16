package pl.bratek20.properties.sources.yaml;

import pl.bratek20.properties.api.PropertiesSource;
import pl.bratek20.properties.api.PropertiesSourceName;
import pl.bratek20.properties.api.PropertiesSourceTest;

class YamlPropertiesSourceTest extends PropertiesSourceTest {

    @Override
    protected PropertiesSource createAndSetupSource() {
        return new YamlPropertiesSource();
    }

    @Override
    protected PropertiesSourceName expectedName() {
        return new PropertiesSourceName("yaml");
    }
}