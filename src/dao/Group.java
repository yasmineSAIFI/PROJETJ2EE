package dao;

import java.util.ArrayList;

public class Group {

	private String nomGroup;
	private long idGroup;
	private ArrayList<Person> personsList;

	public Group(String nomGroup, long idGroup) {
		super();
		this.nomGroup = nomGroup;
		this.idGroup = idGroup;
	}

	public String getNomGroup() {
		return nomGroup;
	}

	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}

	public long getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(long idGroup) {
		this.idGroup = idGroup;
	}

	public ArrayList<Person> getPersonsList() {
		return personsList;
	}

	public void setPersonsList(ArrayList<Person> personsList) {
		this.personsList = personsList;
	}

}
