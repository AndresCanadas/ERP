package com.sge.erp.model;

public class Task {
    private int id_task;
    private int id_project;
    private String dni;
    private String name;

    public Task(int id_task, int id_project, String dni, String name) {
        this.id_task = id_task;
        this.id_project = id_project;
        this.dni = dni;
        this.name = name;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
