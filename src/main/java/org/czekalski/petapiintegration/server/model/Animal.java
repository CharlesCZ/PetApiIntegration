package org.czekalski.petapiintegration.server.model;

public class Animal {
    private Integer id;
    private String name;
    private String breed;
    private String age;
    private String gender;

    private Animal() {
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

    public static class Builder {
        private Integer id;
        private String name;
        private String breed;
        private String age;
        private String gender;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder withAge(String age) {
            this.age = age;
            return this;
        }

        public Builder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Animal build() {
            Animal animal = new Animal();
            animal.id = id;
            animal.name = name;
            animal.breed = breed;
            animal.age = age;
            animal.gender = gender;
            return animal;
        }
    }
}
