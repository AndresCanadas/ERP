package com.sge.erp.model;

public class Project {
    private int id_project;
    private String nif_client;
    private String name;

    public Project(int id_project, String nif_client, String name) {
        this.id_project = id_project;
        this.nif_client = nif_client;
        this.name = name;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getNif_client() {
        return nif_client;
    }

    public void setNif_client(String nif_client) {
        this.nif_client = nif_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
