package pl.bratek20.keyvaluestorage.fixtures

import pl.bratek20.keyvaluestorage.api.Key
import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.Value

class Setup(private val storage: KeyValueStorage) {

    data class SetArgs(var key: String = "", var value: String = "")

    fun set(def: SetArgs.() -> Unit) {
        val args = SetArgs().apply(def)
        storage.set(Key(args.key), Value(args.value))
    }

    fun setMany(configures: List<SetArgs.() -> Unit>) {
        configures.forEach { configure ->
            val args = SetArgs().apply(configure)
            storage.set(Key(args.key), Value(args.value))
        }
    }
}
