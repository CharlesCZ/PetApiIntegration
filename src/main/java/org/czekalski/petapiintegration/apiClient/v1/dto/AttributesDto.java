
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;


public class AttributesDto {


    private final Boolean spayedNeutered;

    private final Boolean houseTrained;

    private final Boolean declawed;

    private final Boolean specialNeeds;

    private final Boolean shotsCurrent;


    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonCreator
    public AttributesDto(@JsonProperty("spayed_neutered")Boolean spayedNeutered,
                         @JsonProperty("house_trained")Boolean houseTrained,
                         @JsonProperty("declawed")Boolean declawed,
                         @JsonProperty("special_needs")Boolean specialNeeds,
                         @JsonProperty("shots_current")Boolean shotsCurrent) {
        this.spayedNeutered = spayedNeutered;
        this.houseTrained = houseTrained;
        this.declawed = declawed;
        this.specialNeeds = specialNeeds;
        this.shotsCurrent = shotsCurrent;
    }


    public Boolean getSpayedNeutered() {
        return spayedNeutered;
    }

    public Boolean getHouseTrained() {
        return houseTrained;
    }

    public Boolean getDeclawed() {
        return declawed;
    }

    public Boolean getSpecialNeeds() {
        return specialNeeds;
    }

    public Boolean getShotsCurrent() {
        return shotsCurrent;
    }
}
