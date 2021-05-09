package com.vacunas.back.models;

public class User {
    private String name;
    private Long tel;
    private String address;
    private String email;
    private String rol;

    public User(String name, Long tel, String address, String email, String rol) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.rol = rol;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
