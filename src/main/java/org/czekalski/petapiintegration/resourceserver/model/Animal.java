package org.czekalski.petapiintegration.resourceserver.model;

public class Animal {
    private Integer id;
    private String name;
    private String breed;
    private String age;
    private String gender;


    public Animal(Integer id, String name, String breed, String age, String gender) {
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
