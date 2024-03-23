package pl.bratek20.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class ProtoFile<F extends GeneratedMessageV3> {
    private final F file;
    private final Descriptors.Descriptor descriptor;

    public  <T extends GeneratedMessageV3> T get(String name, Class<T> clazz) {
        try {
            // Find the field by name
            Descriptors.FieldDescriptor field = descriptor.findFieldByName(name);

            if (field != null && !field.isRepeated()) {
                // Get the value of the field using reflection
                Method getMethod = file.getClass().getMethod("get" + capitalizeFirstLetter(name));
                return clazz.cast(getMethod.invoke(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  <T extends GeneratedMessageV3> List<T> getList(String name, Class<T> clazz) {
        try {
            // Find the field by name
            Descriptors.FieldDescriptor field = descriptor.findFieldByName(name);

            if (field != null && field.isRepeated()) {
                // Get the value of the field using reflection
                Method getMethod = file.getClass().getMethod("get" + capitalizeFirstLetter(name) + "List");
                return (List<T>) getMethod.invoke(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static String capitalizeFirstLetter(String original) {
        if (original == null || original.isEmpty()) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
}
