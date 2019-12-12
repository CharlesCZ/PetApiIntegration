
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ContactDto {



    private final String email;

    private final String phone;

    private final AddressDto address;


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
    public ContactDto( @JsonProperty("email")String email,
                       @JsonProperty("phone")String phone,
                       @JsonProperty("address")AddressDto address) {
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
}
