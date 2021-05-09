package com.vacunas.back.models;

public class Vaccine {
    private String fileName;
    private String date;
    private String name;
    private String veterinarian;

    public Vaccine(String fileName, String date, String name, String veterinarian) {
        this.fileName = fileName;
        this.date = date;
        this.name = name;
        this.veterinarian = veterinarian;
    }

    public Vaccine() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(String veterinarian) {
        this.veterinarian = veterinarian;
    }
}
