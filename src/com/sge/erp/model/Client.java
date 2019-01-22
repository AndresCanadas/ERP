package com.sge.erp.model;

public class Client {
    private String nif;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Client(String nif, String name, String email, String phone, String address) {
        this.nif = nif;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
