
package org.czekalski.petapiintegration.client.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoDto photoDto = (PhotoDto) o;
        return Objects.equals(small, photoDto.small) &&
                Objects.equals(medium, photoDto.medium) &&
                Objects.equals(large, photoDto.large) &&
                Objects.equals(full, photoDto.full);
    }

    @Override
    public int hashCode() {
        return Objects.hash(small, medium, large, full);
    }
}
