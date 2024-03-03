package pl.bratek20.properties.sources.inmemory;

import pl.bratek20.properties.api.PropertiesSource;
import pl.bratek20.properties.api.PropertiesSourceName;
import pl.bratek20.properties.api.PropertiesSourceTest;

class InMemoryPropertiesSourceTest extends PropertiesSourceTest {

    @Override
    protected PropertiesSource createAndSetupSource() {
        var source = new InMemoryPropertiesSource("inmemory");
        source.set(EXPECTED_PROPERTY_NAME, EXPECTED_PROPERTY);
        return source;
    }

    @Override
    protected PropertiesSourceName expectedName() {
        return new PropertiesSourceName("inmemory");
    }
}