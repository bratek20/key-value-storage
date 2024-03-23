package pl.bratek20.fishing.impl

import pl.bratek20.architecture.properties.PropertiesApiMock
import pl.bratek20.fishing.api.FishingApiTest

internal class FishingImplTest : FishingApiTest() {
    override fun createContext(): Context {
        val propertiesApiMock = PropertiesApiMock()
        return Context(
            propertiesApiMock,
            FishingImpl(propertiesApiMock)
        )
    }
}