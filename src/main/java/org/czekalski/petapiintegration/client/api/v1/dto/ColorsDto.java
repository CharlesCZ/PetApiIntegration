package org.czekalski.petapiintegration.client.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorsDto colorsDto = (ColorsDto) o;
        return Objects.equals(primary, colorsDto.primary) &&
                Objects.equals(secondary, colorsDto.secondary) &&
                Objects.equals(tertiary, colorsDto.tertiary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primary, secondary, tertiary);
    }
}
