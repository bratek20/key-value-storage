package pl.bratek20.keyvaluestorage.fixtures

import org.junit.jupiter.api.Assertions
import pl.bratek20.keyvaluestorage.api.KeyValuePair
import pl.bratek20.keyvaluestorage.api.Value

object Assert {
    fun assertValue(given: Value, expected: String?) {
        Assertions.assertEquals(given.value, expected)
    }

    private fun assertKeyValuePair(given: KeyValuePair, expected: ExpectedKeyValuePair) {
        Assertions.assertEquals(given.key.value, expected.key)
        assertValue(given.value, expected.value)
    }

    fun assertKeyValuePairList(given: List<KeyValuePair>, expected: List<ExpectedKeyValuePair>) {
        Assertions.assertEquals(given.size, expected.size)
        for (i in given.indices) {
            assertKeyValuePair(given[i], expected[i])
        }
    }

    data class ExpectedKeyValuePair(val key: String, val value: String)
}
