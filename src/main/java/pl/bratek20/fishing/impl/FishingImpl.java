package pl.bratek20.fishing.impl;

import lombok.RequiredArgsConstructor;
import pl.bratek20.fishing.api.FishId;
import pl.bratek20.fishing.api.Fishery;
import pl.bratek20.fishing.api.FisheryId;
import pl.bratek20.fishing.api.FishingApi;
import pl.bratek20.properties.api.PropertiesApi;
import pl.bratek20.properties.api.PropertyName;

import java.util.List;

@RequiredArgsConstructor
public class FishingImpl implements FishingApi {
    private final PropertiesApi propertiesApi;

    private List<Fishery> getFisheries() {
        return propertiesApi.getList(new PropertyName("fisheries"), Fishery.class);
    }

    @Override
    public FishId catchFish(FisheryId fisheryId) {
        var fishery = getFisheries().stream()
            .filter(f -> f.fisheryId().equals(fisheryId))
            .findFirst().orElseThrow();

        var fishId = fishery.fishIds().get(0);
        return fishId;
    }
}
