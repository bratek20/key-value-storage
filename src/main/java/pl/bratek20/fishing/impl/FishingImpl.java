package pl.bratek20.fishing.impl;

import pl.bratek20.fishing.api.FishId;
import pl.bratek20.fishing.api.Fishery;
import pl.bratek20.fishing.api.FisheryId;
import pl.bratek20.fishing.api.FishingApi;

import java.util.List;

public class FishingImpl implements FishingApi {
    private final List<Fishery> fisheries;

    public FishingImpl(List<Fishery> fisheries) {
        this.fisheries = fisheries;
    }

    @Override
    public FishId catchFish(FisheryId fisheryId) {
        var fishery = fisheries.stream()
            .filter(f -> f.fisheryId().equals(fisheryId))
            .findFirst().orElseThrow();

        var fishId = fishery.fishIds().get(0);
        return fishId;
    }
}
