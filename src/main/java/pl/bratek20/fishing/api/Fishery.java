package pl.bratek20.fishing.api;

import java.util.List;

public record Fishery(FisheryId fisheryId, List<FishId> fishIds) {
}
