package pl.bratek20.keyvaluestorage.fixtures

import org.junit.jupiter.api.Assertions
import pl.bratek20.keyvaluestorage.api.Key
import pl.bratek20.keyvaluestorage.api.KeyValuePair
import pl.bratek20.keyvaluestorage.api.Value

object Assert {
    fun value(given: Value, expected: String) {
        Assertions.assertEquals(given.value, expected)
    }

    private fun keyValuePair(given: KeyValuePair, expectedConfigure: ExpectedKeyValuePair.() -> Unit) {
        val expected = ExpectedKeyValuePair().apply(expectedConfigure)
        if (expected.key != null) {
            Assertions.assertEquals(given.key.value, expected.key)
        }
        if (expected.value != null) {
            Assertions.assertEquals(given.value.value, expected.value)
        }
    }

    fun keyValuePairList(given: List<KeyValuePair>, expectedConfigure: List<ExpectedKeyValuePair.() -> Unit>) {
        Assertions.assertEquals(given.size, expectedConfigure.size)
        given.forEachIndexed { index, keyValuePair ->
            keyValuePair(keyValuePair, expectedConfigure[index])
        }
    }

    fun keyList(given: List<Key>, expected: List<String>) {
        Assertions.assertEquals(given.size, expected.size)
        given.forEachIndexed { index, key ->
            Assertions.assertEquals(key.value, expected[index])
        }
    }

    class ExpectedKeyValuePair(var key: String? = null, var value: String? = null)
}
