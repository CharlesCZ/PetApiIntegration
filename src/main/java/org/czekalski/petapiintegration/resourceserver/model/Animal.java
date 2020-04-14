package org.czekalski.petapiintegration.resourceserver.model;

public class Animal {
    private Integer id;
    private String name;
    private String breed;
    private String age;
    private String gender;


    private Animal(AnimalBuilder animalBuilder) {
        this.id = animalBuilder.id;
        this.name = animalBuilder.name;
        this.breed = animalBuilder.breed;
        this.age = animalBuilder.age;
        this.gender = animalBuilder.gender;
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

        public AnimalBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public AnimalBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public AnimalBuilder setAge(String age) {
            this.age = age;
            return this;
        }

        public AnimalBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Animal build() {
            return new Animal(this);

        }
    }
}
