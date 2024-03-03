package pl.bratek20.fishing.api

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import pl.bratek20.fishing.fixtures.fishery
import pl.bratek20.tests.InterfaceParamsTest

abstract class FishingApiTest : InterfaceParamsTest<FishingApi, List<Fishery>>() {
    override fun defaultParams(): List<Fishery> {
        return listOf(
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
    }

    private lateinit var api: FishingApi

    override fun setup() {
        super.setup()
        api = instance;
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