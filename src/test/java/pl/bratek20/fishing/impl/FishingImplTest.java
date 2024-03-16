package pl.bratek20.fishing.impl;

import pl.bratek20.fishing.api.FishingApiTest;
import pl.bratek20.properties.fixtures.PropertiesApiMock;

class FishingImplTest extends FishingApiTest {

    @Override
    protected Context createContext() {
        var propertiesApiMock = new PropertiesApiMock();
        return new Context(
            propertiesApiMock,
            new FishingImpl(propertiesApiMock)
        );
    }
}