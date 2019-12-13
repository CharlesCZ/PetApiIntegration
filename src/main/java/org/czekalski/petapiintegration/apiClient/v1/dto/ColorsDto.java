
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;


public class ColorsDto {
    private final String primary;

    private final String secondary;

    private final String tertiary;

    @JsonCreator
    public ColorsDto(
            @JsonProperty("primary") String primary,
            @JsonProperty("secondary") String secondary,
            @JsonProperty("tertiary") String tertiary) {
        this.primary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
    }


    public String getPrimary() {
        return primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public String getTertiary() {
        return tertiary;
    }
}
