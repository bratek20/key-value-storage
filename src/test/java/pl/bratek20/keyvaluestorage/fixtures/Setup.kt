package pl.bratek20.keyvaluestorage.fixtures

import pl.bratek20.keyvaluestorage.api.Key
import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.Value

class Setup(private val storage: KeyValueStorage) {

    data class SetArgs(val key: String, val value: String)

    fun set(args: SetArgs) {
        storage.set(Key(args.key),Value(args.value))
    }

    fun setMany(args: List<SetArgs>) {
        args.forEach(this::set)
    }
}
