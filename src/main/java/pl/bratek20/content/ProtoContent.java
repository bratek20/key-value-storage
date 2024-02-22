package pl.bratek20.content;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import pl.bratek20.proto.ContentProto;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class ProtoContent {
    private static ContentProto.Content create() {
        // Create a Fishery message
        ContentProto.Fishery fishery = ContentProto.Fishery.newBuilder()
            .setId(1)
            .addFishIds("FishID1")
            .addFishIds("FishID2")
            .build();

// Create another Fishery message
        ContentProto.Fishery anotherFishery = ContentProto.Fishery.newBuilder()
            .setId(2)
            .addFishIds("FishID3")
            .addFishIds("FishID4")
            .build();

// Create a Content message containing the list of Fishery messages
        ContentProto.Content content = ContentProto.Content.newBuilder()
            .addFisheries(fishery)
            .addFisheries(anotherFishery)
            .build();

        return content;
    }

    private static ContentProto.Content content = create();


    public  <T extends GeneratedMessageV3> List<T> getList(String name, Class<T> clazz) {
        try {
            // Obtain the descriptor for the Content message
            Descriptors.Descriptor descriptor = ContentProto.Content.getDescriptor();
            // Find the field by name
            Descriptors.FieldDescriptor field = descriptor.findFieldByName(name);

            if (field != null && field.isRepeated()) {
                // Get the value of the field using reflection
                Method getMethod = content.getClass().getMethod("get" + capitalizeFirstLetter(name) + "List");
                return (List<T>) getMethod.invoke(content);
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
