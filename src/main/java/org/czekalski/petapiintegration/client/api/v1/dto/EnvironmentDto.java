package org.czekalski.petapiintegration.client.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EnvironmentDto {
    private final Boolean children;

    private final Boolean dogs;

    private final Boolean cats;

    @JsonCreator
    public EnvironmentDto(
            @JsonProperty("children") Boolean children,
            @JsonProperty("dogs") Boolean dogs,
            @JsonProperty("cats") Boolean cats) {
        this.children = children;
        this.dogs = dogs;
        this.cats = cats;
    }

    public Boolean getChildren() {
        return children;
    }

    public Boolean getDogs() {
        return dogs;
    }

    public Boolean getCats() {
        return cats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnvironmentDto that = (EnvironmentDto) o;
        return Objects.equals(children, that.children) &&
                Objects.equals(dogs, that.dogs) &&
                Objects.equals(cats, that.cats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, dogs, cats);
    }
}
