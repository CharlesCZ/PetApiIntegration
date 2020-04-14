
package org.czekalski.petapiintegration.client.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class AnimalDto {
    private final int id;

    private final String organizationId;

    private final String url;

    private final String type;

    private final String species;

    private final BreedsDto breeds;

    private final ColorsDto colors;

    private final String age;

    private final String gender;

    private final String size;

    private final String coat;

    private final AttributesDto attributes;

    private final EnvironmentDto environment;

    private final List<String> tags;

    private final String name;

    private final String description;

    private final List<PhotoDto> photos;

    private final String status;

    private final String statusChangedAt;

    private final String publishedAt;

    private final Double distance;

    private final ContactDto contact;

    @JsonCreator
    public AnimalDto(
            @JsonProperty("id") int id,
            @JsonProperty("organization_id") String organizationId,
            @JsonProperty("url") String url,
            @JsonProperty("type") String type,
            @JsonProperty("species") String species,
            @JsonProperty("breeds") BreedsDto breeds,
            @JsonProperty("colors") ColorsDto colors,
            @JsonProperty("age") String age,
            @JsonProperty("gender") String gender,
            @JsonProperty("size") String size,
            @JsonProperty("coat") String coat,
            @JsonProperty("attributes") AttributesDto attributes,
            @JsonProperty("environment") EnvironmentDto environment,
            @JsonProperty("tags") List<String> tags,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("photos") List<PhotoDto> photos,
            @JsonProperty("status") String status,
            @JsonProperty("status_changed_at") String statusChangedAt,
            @JsonProperty("published_at") String publishedAt,
            @JsonProperty("distance") Double distance,
            @JsonProperty("contact") ContactDto contact) {
        this.id = id;
        this.organizationId = organizationId;
        this.url = url;
        this.type = type;
        this.species = species;
        this.breeds = breeds;
        this.colors = colors;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.coat = coat;
        this.attributes = attributes;
        this.environment = environment;
        this.tags = tags;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.status = status;
        this.statusChangedAt = statusChangedAt;
        this.publishedAt = publishedAt;
        this.distance = distance;
        this.contact = contact;
    }


    public int getId() {
        return id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getSpecies() {
        return species;
    }

    public BreedsDto getBreeds() {
        return breeds;
    }

    public ColorsDto getColors() {
        return colors;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSize() {
        return size;
    }

    public String getCoat() {
        return coat;
    }

    public AttributesDto getAttributes() {
        return attributes;
    }

    public EnvironmentDto getEnvironment() {
        return environment;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<PhotoDto> getPhotos() {
        return photos;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusChangedAt() {
        return statusChangedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public Double getDistance() {
        return distance;
    }

    public ContactDto getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return id == animalDto.id &&
                Objects.equals(organizationId, animalDto.organizationId) &&
                Objects.equals(url, animalDto.url) &&
                Objects.equals(type, animalDto.type) &&
                Objects.equals(species, animalDto.species) &&
                Objects.equals(breeds, animalDto.breeds) &&
                Objects.equals(colors, animalDto.colors) &&
                Objects.equals(age, animalDto.age) &&
                Objects.equals(gender, animalDto.gender) &&
                Objects.equals(size, animalDto.size) &&
                Objects.equals(coat, animalDto.coat) &&
                Objects.equals(attributes, animalDto.attributes) &&
                Objects.equals(environment, animalDto.environment) &&
                Objects.equals(tags, animalDto.tags) &&
                Objects.equals(name, animalDto.name) &&
                Objects.equals(description, animalDto.description) &&
                Objects.equals(photos, animalDto.photos) &&
                Objects.equals(status, animalDto.status) &&
                Objects.equals(statusChangedAt, animalDto.statusChangedAt) &&
                Objects.equals(publishedAt, animalDto.publishedAt) &&
                Objects.equals(distance, animalDto.distance) &&
                Objects.equals(contact, animalDto.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organizationId, url, type, species, breeds, colors, age, gender, size, coat, attributes, environment, tags, name, description, photos, status, statusChangedAt, publishedAt, distance, contact);
    }
}
