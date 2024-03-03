package pl.bratek20.fishing.fixtures

import pl.bratek20.fishing.api.FishId
import pl.bratek20.fishing.api.Fishery
import pl.bratek20.fishing.api.FisheryId

data class FisheryDef(
    var id: String = "",
    var fishIds: List<String> = listOf()
)

fun fishery(overrides: FisheryDef.() -> Unit): Fishery {
    val def = FisheryDef().apply(overrides)

    return Fishery(
        FisheryId(def.id),
        def.fishIds.map { FishId(it) }
    )
}