package pl.bratek20.keyvaluestorage.fixtures

import org.junit.jupiter.api.Assertions
import pl.bratek20.keyvaluestorage.api.KeyValuePair
import pl.bratek20.keyvaluestorage.api.Value

object Assert {
    fun value(given: Value, expected: String) {
        Assertions.assertEquals(given.value, expected)
    }

    private fun keyValuePair(given: KeyValuePair, expectedConfigure: ExpectedKeyValuePair.() -> Unit) {
        val expected = ExpectedKeyValuePair().apply(expectedConfigure)
        Assertions.assertEquals(given.key.value, expected.key)
        value(given.value, expected.value)
    }

    fun keyValuePairList(given: List<KeyValuePair>, expectedConfigure: List<ExpectedKeyValuePair.() -> Unit>) {
        Assertions.assertEquals(given.size, expectedConfigure.size)
        given.forEachIndexed { index, keyValuePair ->
            keyValuePair(keyValuePair, expectedConfigure[index])
        }
    }

    class ExpectedKeyValuePair(var key: String = "", var value: String = "")
}
