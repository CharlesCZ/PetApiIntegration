
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;


public class AttributesDto {
    private final boolean spayedNeutered;

    private final boolean houseTrained;

    //inside petfinder API can be null
    private final Boolean declawed;

    private final boolean specialNeeds;

    private final boolean shotsCurrent;

    @JsonCreator
    public AttributesDto(
            @JsonProperty("spayed_neutered") boolean spayedNeutered,
            @JsonProperty("house_trained") boolean houseTrained,
            @JsonProperty("declawed") Boolean declawed,
            @JsonProperty("special_needs") boolean specialNeeds,
            @JsonProperty("shots_current") boolean shotsCurrent) {
        this.spayedNeutered = spayedNeutered;
        this.houseTrained = houseTrained;
        this.declawed = declawed;
        this.specialNeeds = specialNeeds;
        this.shotsCurrent = shotsCurrent;
    }


    public boolean getSpayedNeutered() {
        return spayedNeutered;
    }

    public boolean getHouseTrained() {
        return houseTrained;
    }

    public Boolean getDeclawed() {
        return declawed;
    }

    public boolean getSpecialNeeds() {
        return specialNeeds;
    }

    public boolean getShotsCurrent() {
        return shotsCurrent;
    }
}
