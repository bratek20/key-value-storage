package pl.bratek20.keyvaluestorage.api

@JvmRecord
data class Key(val value: String)

@JvmRecord
data class Value(val value: String)

@JvmRecord
data class KeyValuePair(val key: Key, val value: Value)

