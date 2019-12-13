
package org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AnimalResourceDto {
    private final Integer id;

    private final String name;

    private final String breed;

    private final String age;

    private final String gender;

    @JsonCreator
    public AnimalResourceDto(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("breed") String breed,
            @JsonProperty("age") String age,
            @JsonProperty("gender") String gender) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
