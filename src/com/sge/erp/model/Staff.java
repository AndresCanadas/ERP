package com.sge.erp.model;

public class Staff {
    private String dni;
    private int id_task;
    private String name;
    private String surname;
    private String job;

    public Staff(String dni, int id_task, String name, String surname, String job) {
        this.dni = dni;
        this.id_task = id_task;
        this.name = name;
        this.surname = surname;
        this.job = job;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
