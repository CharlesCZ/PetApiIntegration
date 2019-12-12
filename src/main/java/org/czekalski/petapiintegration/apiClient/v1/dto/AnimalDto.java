
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;


public class AnimalDto {


    private Integer id;

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
    public AnimalDto( @JsonProperty("id")Integer id,
                      @JsonProperty("organization_id") String organizationId,
                      @JsonProperty("url") String url,
                      @JsonProperty("type") String type,
                      @JsonProperty("species")String species,
                      @JsonProperty("breeds") BreedsDto breeds,
                      @JsonProperty("colors")ColorsDto colors,
                      @JsonProperty("age")String age,
                      @JsonProperty("gender") String gender,
                      @JsonProperty("size")  String size,
                      @JsonProperty("coat")String coat,
                      @JsonProperty("attributes") AttributesDto attributes,
                      @JsonProperty("environment") EnvironmentDto environment,
                      @JsonProperty("tags")   List<String> tags,
                      @JsonProperty("name")String name,
                      @JsonProperty("description")String description,
                      @JsonProperty("photos") List<PhotoDto> photos,
                      @JsonProperty("status") String status,
                      @JsonProperty("status_changed_at")String statusChangedAt,
                      @JsonProperty("published_at")String publishedAt,
                      @JsonProperty("distance")Double distance,
                      @JsonProperty("contact")ContactDto contact) {
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


    public Integer getId() {
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
}
