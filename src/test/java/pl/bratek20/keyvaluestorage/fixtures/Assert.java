package pl.bratek20.keyvaluestorage.fixtures;

import pl.bratek20.keyvaluestorage.api.KeyValuePair;
import pl.bratek20.keyvaluestorage.api.Value;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assert {
    public static void assertValue(Value given, String expected) {
        assertEquals(given.value(), expected);
    }

    public record ExpectedKeyValuePair(String key, String value) { }
    private static void assertKeyValuePair(KeyValuePair given, ExpectedKeyValuePair expected) {
        assertEquals(given.key().value(), expected.key());
        assertValue(given.value(), expected.value());
    }

    public static void assertKeyValuePairList(List<KeyValuePair> given, List<ExpectedKeyValuePair> expected) {
        assertEquals(given.size(), expected.size());
        for (var i = 0; i < given.size(); i++) {
            assertKeyValuePair(given.get(i), expected.get(i));
        }
    }
}
