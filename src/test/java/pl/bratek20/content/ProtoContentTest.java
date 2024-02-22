package pl.bratek20.content;

import org.junit.jupiter.api.Test;
import pl.bratek20.proto.ContentProto;

import static org.junit.jupiter.api.Assertions.*;

class ProtoContentTest {
    @Test
    void x() {
        ProtoContent protoContent = new ProtoContent();
        var fisheries = protoContent.getList("fisheries", ContentProto.Fishery.class);

        assertEquals(2, fisheries.size());
        assertEquals(1, fisheries.get(0).getId());
        assertEquals(2, fisheries.get(1).getId());
        assertEquals(2, fisheries.get(0).getFishIdsCount());
        assertEquals(2, fisheries.get(1).getFishIdsCount());
        assertEquals("FishID1", fisheries.get(0).getFishIds(0));
        assertEquals("FishID2", fisheries.get(0).getFishIds(1));
        assertEquals("FishID3", fisheries.get(1).getFishIds(0));
        assertEquals("FishID4", fisheries.get(1).getFishIds(1));
    }
}