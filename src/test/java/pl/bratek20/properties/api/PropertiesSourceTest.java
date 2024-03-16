package pl.bratek20.properties.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class PropertiesSourceTest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    protected static class SomeProperty {
        private String value;
        private String otherValue;
    }
    protected record OtherProperty(String value) { }

    protected static PropertyName SOME_PROPERTY_NAME = new PropertyName("someProperty");
    protected static SomeProperty EXPECTED_SOME_PROPERTY = new SomeProperty("some value", "other value");

    protected static PropertyName SOME_PROPERTY_LIST_NAME = new PropertyName("somePropertyList");
    protected static List<SomeProperty> EXPECTED_SOME_PROPERTY_LIST = List.of(
        new SomeProperty("some value 1", "x"),
        new SomeProperty("some value 2", "x")
    );

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
        assertThat(source.get(SOME_PROPERTY_NAME, SomeProperty.class))
            .isEqualTo(EXPECTED_SOME_PROPERTY);
    }

    @Test
    void shouldGetExpectedPropertyList() {
        assertThat(source.getList(SOME_PROPERTY_LIST_NAME, SomeProperty.class))
            .isEqualTo(EXPECTED_SOME_PROPERTY_LIST);
    }

    @Nested
    class HasOfTypeScope {
        @Test
        void shouldReturnTrueForExistingProperty() {
            assertThat(source.hasOfType(SOME_PROPERTY_NAME, SomeProperty.class))
                .isTrue();
        }

        @Test
        void shouldReturnFalseForNotExistingProperty() {
            assertThat(source.hasOfType(new PropertyName("notExisting"), SomeProperty.class))
                .isFalse();
        }

        @Test
        void shouldReturnFalseForPropertyOfDifferentType() {
            assertThat(source.hasOfType(SOME_PROPERTY_NAME, OtherProperty.class))
                .isFalse();
        }
    }
}