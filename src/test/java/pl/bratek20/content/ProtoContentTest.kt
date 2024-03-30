package pl.bratek20.content

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import pl.bratek20.proto.ContentProto

internal class ProtoContentTest {
    @Test
    fun x() {
        val protoContent = ProtoContent()
        val fisheries = protoContent.getList("fisheries", ContentProto.Fishery::class.java)

        Assertions.assertEquals(2, fisheries.size)
        Assertions.assertEquals(1, fisheries[0].id)
        Assertions.assertEquals(2, fisheries[1].id)
        Assertions.assertEquals(2, fisheries[0].fishIdsCount)
        Assertions.assertEquals(2, fisheries[1].fishIdsCount)
        Assertions.assertEquals("FishID1", fisheries[0].getFishIds(0))
        Assertions.assertEquals("FishID2", fisheries[0].getFishIds(1))
        Assertions.assertEquals("FishID3", fisheries[1].getFishIds(0))
        Assertions.assertEquals("FishID4", fisheries[1].getFishIds(1))
    }
}