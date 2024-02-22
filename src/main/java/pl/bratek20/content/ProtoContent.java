package pl.bratek20.content;

import pl.bratek20.proto.ContentProto;

public class ProtoContent {
    public ContentProto.Content create() {
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
}
