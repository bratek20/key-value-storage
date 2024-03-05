package pl.bratek20.content;

import com.google.protobuf.GeneratedMessageV3;
import pl.bratek20.proto.ContentProto;
import pl.bratek20.proto.ProtoFile;

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
        return ContentProto.Content.newBuilder()
            .addFisheries(fishery)
            .addFisheries(anotherFishery)
            .build();
    }

    private static final ProtoFile<ContentProto.Content> content = new ProtoFile<>(create(), ContentProto.Content.getDescriptor());

    public  <T extends GeneratedMessageV3> List<T> getList(String name, Class<T> clazz) {
        return content.getList(name, clazz);
    }
}
