
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
