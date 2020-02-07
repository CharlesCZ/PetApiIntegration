package org.czekalski.petapiintegration.apiclient.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(address1, that.address1) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(postcode, that.postcode) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address1, address2, city, state, postcode, country);
    }
}
