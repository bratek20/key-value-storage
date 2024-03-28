package pl.bratek20.keyvaluestorage.fixtures

import org.assertj.core.api.Assertions.assertThat
import pl.bratek20.keyvaluestorage.api.Key
import pl.bratek20.keyvaluestorage.api.KeyValuePair
import pl.bratek20.keyvaluestorage.api.Value

object Assert {
    fun value(given: Value, expected: String) {
        assertThat(given.value).isEqualTo(expected)
    }

    private fun keyValuePair(given: KeyValuePair, expectedConfigure: ExpectedKeyValuePair.() -> Unit) {
        val expected = ExpectedKeyValuePair().apply(expectedConfigure)
        if (expected.key != null) {
            assertThat(given.key.value).isEqualTo(expected.key)
        }
        if (expected.value != null) {
            assertThat(given.value.value).isEqualTo(expected.value)
        }
    }

    fun keyValuePairList(given: List<KeyValuePair>, expected: List<ExpectedKeyValuePair.() -> Unit>) {
        assertThat(given).hasSize(expected.size)
        given.forEachIndexed { index, keyValuePair ->
            keyValuePair(keyValuePair, expected[index])
        }
    }

    fun keyList(given: List<Key>, expected: List<String>) {
        assertThat(given).hasSize(expected.size)
        given.forEachIndexed { index, key ->
            assertThat(key.value).isEqualTo(expected[index])
        }
    }

    class ExpectedKeyValuePair(var key: String? = null, var value: String? = null)
}
