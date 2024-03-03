package pl.bratek20.fishing.impl;

import pl.bratek20.fishing.api.Fishery;
import pl.bratek20.fishing.api.FishingApi;
import pl.bratek20.fishing.api.FishingApiTest;

import java.util.List;

class FishingImplTest extends FishingApiTest {

    @Override
    protected FishingApi createInstance(List<? extends Fishery> params) {
        return new FishingImpl();
    }
}