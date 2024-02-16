package pl.bratek20.keyvaluestorage.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class KeyValueStorageTest {
    protected abstract KeyValueStorage createStorage();

    private KeyValueStorage storage;

    @BeforeEach
    void beforeEach() {
        storage = createStorage();
    }

    @Test
    void shouldSetAndGetValue() {
        Key key = new Key("key");
        Value value = new Value("value");

        storage.set(key, value);
        var result = storage.get(key);

        assertEquals(value, result);
    }

    @Test
    void shouldGetAll() {
        Key key1 = new Key("key1");
        Value value1 = new Value("value1");
        Key key2 = new Key("key2");
        Value value2 = new Value("value2");

        storage.set(key1, value1);
        storage.set(key2, value2);

        var result = storage.getAll();

        assertEquals(2, result.size());
        assertTrue(result.contains(new KeyValuePair(key1, value1)));
        assertTrue(result.contains(new KeyValuePair(key2, value2)));
    }
}