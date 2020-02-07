package org.czekalski.petapiintegration.apiclient.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ContactDto {
    private final String email;

    private final String phone;

    private final AddressDto address;

    @JsonCreator
    public ContactDto(
            @JsonProperty("email") String email,
            @JsonProperty("phone") String phone,
            @JsonProperty("address") AddressDto address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public AddressDto getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDto that = (ContactDto) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phone, address);
    }
}
