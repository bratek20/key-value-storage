package pl.bratek20.keyvaluestorage.fixtures

import pl.bratek20.keyvaluestorage.api.Key
import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.Value
import sun.tools.jstat.Closure

class Setup {
    private KeyValueStorage storage

    Setup(KeyValueStorage storage) {
        this.storage = storage
    }

    static class SetArgs {
        String key = ''
        String value = ''
    }

    void set(Closure configure) {
        configure.delegate = new SetArgs()
        configure.call()
        storage.set(new Key(configure.delegate.key), new Value(configure.delegate.value))
    }

    void setMany(List<Closure> configures) {
        configures.each { configure ->
            set(configure)
        }
    }
}
