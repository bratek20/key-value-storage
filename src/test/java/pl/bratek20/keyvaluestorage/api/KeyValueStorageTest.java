package pl.bratek20.keyvaluestorage.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.bratek20.keyvaluestorage.fixtures.Assert;
import pl.bratek20.keyvaluestorage.fixtures.Setup;

import java.util.List;

import static pl.bratek20.keyvaluestorage.fixtures.Assert.assertKeyValuePairList;
import static pl.bratek20.keyvaluestorage.fixtures.Assert.assertValue;

public abstract class KeyValueStorageTest {
    protected abstract KeyValueStorage createStorage();

    private KeyValueStorage storage;
    private Setup setup;

    @BeforeEach
    void beforeEach() {
        storage = createStorage();
        setup = new Setup(storage);
    }

    @Test
    void shouldSetAndGetValue() {
        setup.set(new Setup.SetArgs("key", "value"));

        var result = storage.get(new Key("key"));

        assertValue(result, "value");
    }

    @Test
    void shouldGetAll() {
        setup.setMany(
            List.of(
                new Setup.SetArgs("key1", "value1"),
                new Setup.SetArgs("key2", "value2")
            )
        );

        var result = storage.getAll();

        assertKeyValuePairList(
            result,
            List.of(
                new Assert.ExpectedKeyValuePair("key1", "value1"),
                new Assert.ExpectedKeyValuePair("key2", "value2")
            )
        );
    }
}