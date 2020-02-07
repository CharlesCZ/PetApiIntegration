
package org.czekalski.petapiintegration.apiclient.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributesDto that = (AttributesDto) o;
        return spayedNeutered == that.spayedNeutered &&
                houseTrained == that.houseTrained &&
                specialNeeds == that.specialNeeds &&
                shotsCurrent == that.shotsCurrent &&
                Objects.equals(declawed, that.declawed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spayedNeutered, houseTrained, declawed, specialNeeds, shotsCurrent);
    }
}
