package com.vacunas.back.models;

public class Pet {
    private String name;
    private String age;
    private String color;
    private String breed;
    private float weight;
    private float height;
    private String gender;

    public Pet(String name, String age, String color, String breed, float weight, float height, String gender) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.breed = breed;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
