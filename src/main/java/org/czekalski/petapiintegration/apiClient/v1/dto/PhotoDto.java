
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PhotoDto {

    private final String small;

    private final String medium;

    private final String large;

    private final String full;

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
    public PhotoDto(   @JsonProperty("small")String small,
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
