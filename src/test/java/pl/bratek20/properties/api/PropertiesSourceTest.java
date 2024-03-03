package pl.bratek20.properties.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class PropertiesSourceTest {
    protected record SomeProperty(String value) { }

    protected static PropertyName EXPECTED_PROPERTY_NAME = new PropertyName("someProperty");
    protected static SomeProperty EXPECTED_PROPERTY = new SomeProperty("some value");

    protected abstract PropertiesSource createAndSetupSource();
    protected abstract PropertiesSourceName expectedName();

    private PropertiesSource source;

    @BeforeEach
    void beforeEach() {
        source = createAndSetupSource();
    }

    @Test
    void shouldReturnExpectedName() {
        assertThat(source.getName()).isEqualTo(expectedName());
    }

    @Test
    void shouldGetExpectedProperty() {
        assertThat(source.get(EXPECTED_PROPERTY_NAME, SomeProperty.class))
            .isEqualTo(EXPECTED_PROPERTY);
    }
}