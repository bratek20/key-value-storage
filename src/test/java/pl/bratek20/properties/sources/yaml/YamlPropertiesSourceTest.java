package pl.bratek20.properties.sources.yaml;

import pl.bratek20.properties.api.PropertiesSource;
import pl.bratek20.properties.api.PropertiesSourceId;
import pl.bratek20.properties.api.PropertiesSourceTest;

class YamlPropertiesSourceTest extends PropertiesSourceTest {

    @Override
    protected PropertiesSource createAndSetupSource() {
        return new YamlPropertiesSource();
    }

    @Override
    protected PropertiesSourceId expectedName() {
        return new PropertiesSourceId("yaml");
    }
}