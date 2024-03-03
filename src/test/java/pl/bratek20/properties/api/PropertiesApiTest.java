package pl.bratek20.properties.api;

import org.junit.jupiter.api.Test;
import pl.bratek20.tests.InterfaceParamsTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class PropertiesApiTest extends InterfaceParamsTest<PropertiesApi, List<PropertiesSource>> {
    private final PropertiesSourceMock sourceMock = new PropertiesSourceMock();

    @Override
    protected List<PropertiesSource> defaultParams() {
        return List.of(
            sourceMock
        );
    }

    private PropertiesApi api;

    @Override
    protected void setup() {
        super.setup();
        api = instance;
    }

    record MyProperty(String value) {}

    @Test
    void shouldGetProperty() {
        var prop = new MyProperty("x");
        sourceMock.set("mine", prop);

        var x = api.get(new PropertiesSourceName("mock"), new PropertyName("mine"), MyProperty.class);

        assertEquals(prop, x);
    }
}