package com.sge.erp.model;

public class Team {
    private int id_team;
    private int id_project;
    private String name;

    public Team(int id_team, int id_project, String name) {
        this.id_team = id_team;
        this.id_project = id_project;
        this.name = name;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
