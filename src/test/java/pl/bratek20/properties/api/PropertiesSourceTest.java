package pl.bratek20.properties.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class PropertiesSourceTest {
    protected record SomeProperty(String value) { }
    protected record OtherProperty(String value) { }

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

    @Test
    void shouldSupportHasOfType() {
        assertThat(source.hasOfType(EXPECTED_PROPERTY_NAME, SomeProperty.class))
            .isTrue();

        assertThat(source.hasOfType(new PropertyName("notExisting"), SomeProperty.class))
            .isFalse();
        assertThat(source.hasOfType(EXPECTED_PROPERTY_NAME, OtherProperty.class))
            .isFalse();

    }
}