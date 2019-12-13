
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;


public class AddressDto {
    private final String address1;

    private final String address2;

    private final String city;

    private final String state;

    private final String postcode;

    private final String country;

    @JsonCreator
    public AddressDto(
            @JsonProperty("address1") String address1,
            @JsonProperty("address2") String address2,
            @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("postcode") String postcode,
            @JsonProperty("country") String country) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }


    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }
}
