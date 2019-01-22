package com.sge.erp.model;

public class Staff_Team {
	private int id_team;
	private String dni;
	
	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Staff_Team(int id_team, String dni) {
		super();
		this.id_team = id_team;
		this.dni = dni;
	}
}
