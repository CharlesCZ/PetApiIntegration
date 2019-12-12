
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;


public class BreedsDto {



    private final String primary;

    private final Object secondary;

    private final Boolean mixed;

    private final Boolean unknown;


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
    public BreedsDto( @JsonProperty("primary")String primary,
                      @JsonProperty("secondary")Object secondary,
                      @JsonProperty("mixed") Boolean mixed,
                      @JsonProperty("unknown")Boolean unknown) {
        this.primary = primary;
        this.secondary = secondary;
        this.mixed = mixed;
        this.unknown = unknown;
    }


    public String getPrimary() {
        return primary;
    }

    public Object getSecondary() {
        return secondary;
    }

    public Boolean getMixed() {
        return mixed;
    }

    public Boolean getUnknown() {
        return unknown;
    }
}
