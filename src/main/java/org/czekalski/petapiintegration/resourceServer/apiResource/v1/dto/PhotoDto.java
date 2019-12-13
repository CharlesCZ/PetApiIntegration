
package org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PhotoDto {
    private final String small;

    private final String medium;

    private final String large;

    private final String full;

    @JsonCreator
    public PhotoDto(
            @JsonProperty("small") String small,
            @JsonProperty("medium") String medium,
            @JsonProperty("large") String large,
            @JsonProperty("full") String full) {
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.full = full;
    }


    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }

    public String getFull() {
        return full;
    }
}
