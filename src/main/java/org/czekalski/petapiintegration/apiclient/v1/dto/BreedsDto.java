
package org.czekalski.petapiintegration.apiclient.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreedsDto breedsDto = (BreedsDto) o;
        return mixed == breedsDto.mixed &&
                unknown == breedsDto.unknown &&
                Objects.equals(primary, breedsDto.primary) &&
                Objects.equals(secondary, breedsDto.secondary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primary, secondary, mixed, unknown);
    }
}
