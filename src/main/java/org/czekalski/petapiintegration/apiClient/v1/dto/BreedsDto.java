
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;


public class BreedsDto {
    private final String primary;

    private final String secondary;

    private final boolean mixed;

    private final boolean unknown;

    @JsonCreator
    public BreedsDto(
            @JsonProperty("primary") String primary,
            @JsonProperty("secondary") String secondary,
            @JsonProperty("mixed") boolean mixed,
            @JsonProperty("unknown") boolean unknown) {
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

    public boolean getMixed() {
        return mixed;
    }

    public boolean getUnknown() {
        return unknown;
    }
}
