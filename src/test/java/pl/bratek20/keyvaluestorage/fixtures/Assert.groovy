import org.junit.jupiter.api.Assertions
import pl.bratek20.keyvaluestorage.api.Key
import pl.bratek20.keyvaluestorage.api.KeyValuePair
import pl.bratek20.keyvaluestorage.api.Value
import sun.tools.jstat.Closure

class Assert {
    static void value(Value given, String expected) {
        Assertions.assertEquals(given.value, expected)
    }

    private static void keyValuePair(KeyValuePair given, Closure expectedConfigure) {
        def expected = new ExpectedKeyValuePair()
        expectedConfigure.call(expected)
        if (expected.key != null) {
            Assertions.assertEquals(given.key.value, expected.key)
        }
        if (expected.value != null) {
            Assertions.assertEquals(given.value.value, expected.value)
        }
    }

    static void keyValuePairList(List<KeyValuePair> given, List<Closure> expectedConfigure) {
        Assertions.assertEquals(given.size(), expectedConfigure.size())
        given.eachWithIndex { keyValuePair, index ->
            keyValuePair(keyValuePair, expectedConfigure[index])
        }
    }

    static void keyList(List<Key> given, List<String> expected) {
        Assertions.assertEquals(given.size(), expected.size())
        given.eachWithIndex { key, index ->
            Assertions.assertEquals(key.value, expected[index])
        }
    }

    static class ExpectedKeyValuePair {
        String key
        String value
    }
}
