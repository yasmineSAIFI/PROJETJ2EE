package dao;

import java.util.ArrayList;

public class Group {

	private String nomGroup;
	private int idGroup;
	private ArrayList<Person> personsList;
	
	
	
	public String getNomGroup() {
		return nomGroup;
	}
	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}
	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public ArrayList<Person> getPersonsList() {
		return personsList;
	}
	public void setPersonsList(ArrayList<Person> personsList) {
		this.personsList = personsList;
	}

	

}
