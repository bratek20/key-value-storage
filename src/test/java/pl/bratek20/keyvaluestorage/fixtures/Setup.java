package pl.bratek20.keyvaluestorage.fixtures;

import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValueStorage;
import pl.bratek20.keyvaluestorage.api.Value;

import java.util.List;

public class Setup {
    private final KeyValueStorage storage;

    public Setup(KeyValueStorage storage) {
        this.storage = storage;
    }

    public record SetArgs(String key, String value) { }
    public void set(SetArgs args) {
        storage.set(new Key(args.key()), new Value(args.value()));
    }

    public void setMany(List<SetArgs> args) {
        args.forEach(this::set);
    }
}
