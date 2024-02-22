package pl.bratek20.content;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProtoContentTest {
    @Test
    void x() {
        ProtoContent protoContent = new ProtoContent();
        var content = protoContent.create();

        assertEquals(2, content.getFisheriesCount());
        assertEquals(1, content.getFisheries(0).getId());
        assertEquals(2, content.getFisheries(1).getId());
        assertEquals(2, content.getFisheries(1).getFishIdsCount());
        assertEquals("FishID3", content.getFisheries(1).getFishIds(0));
        assertEquals("FishID4", content.getFisheries(1).getFishIds(1));
    }
}