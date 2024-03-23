package pl.bratek20.fishing.impl;

import pl.bratek20.architecture.properties.PropertiesApiMock;
import pl.bratek20.fishing.api.FishingApiTest;

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