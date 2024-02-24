package pl.bratek20.fishing.impl;

import pl.bratek20.fishing.api.FishId;
import pl.bratek20.fishing.api.FisheryId;
import pl.bratek20.fishing.api.FishingApi;

public class FishingImpl implements FishingApi {
    @Override
    public FishId catchFish(FisheryId fisheryId) {
        return new FishId("fish");
    }
}
