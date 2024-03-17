package pl.bratek20.fishing.api

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import pl.bratek20.fishing.fixtures.fishery
import pl.bratek20.properties.fixtures.PropertiesApiMock
import pl.bratek20.tests.ContextTest

abstract class FishingApiTest : ContextTest<FishingApiTest.Context>() {
    data class Context(
        val propertiesApiMock: PropertiesApiMock,
        val api: FishingApi
    )

    private lateinit var propertiesApiMock: PropertiesApiMock
    private lateinit var api: FishingApi

    override fun applyContext(context: Context) {
        propertiesApiMock = context.propertiesApiMock
        api = context.api

        propertiesApiMock.setProperty("fisheries",
            listOf(
                fishery {
                    id = "1"
                    fishIds = listOf(
                        "myFish"
                    )
                },
                fishery {
                    id = "2"
                    fishIds = listOf(
                        "myFish2"
                    )
                }
            )
        )
    }

    @Test
    fun shouldCatchFish() {
        val fishId = api.catchFish(FisheryId("1"))

        assertEquals(fishId.value, "myFish")
    }

    @Test
    fun shouldCatchFishFromOtherFishery() {
        val fishId = api.catchFish(FisheryId("2"))

        assertEquals(fishId.value, "myFish2")
    }
}