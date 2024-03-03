package pl.bratek20.properties.api;

public class PropertiesSourceMock implements PropertiesSource {
    @Override
    public PropertiesSourceName getName() {
        return new PropertiesSourceName("mock");
    }

    private Object last;

    @Override
    public <T> T get(PropertyName name, Class<T> type) {
        return type.cast(last);
    }

    public void set(String name, Object property) {
        last = property;
    }
}
