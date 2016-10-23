package dao;

import java.util.Date;

public class Person {
	// identifiant, nom, prénom, adresse électronique, site WEB, date de
	// naissance et mot de passe.

	private int idPerson;
	private String firstName;
	private String lastName;
	private String mail;
	private String webSite;
	private Date birthDate;
	private String password;
	private long idGroup;
	
	public Person(int idPerson, String firstName, String lastName, String mail, String webSite, Date birthDate,
			String password, long idGroup) {
		super();
		this.idPerson = idPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.webSite = webSite;
		this.birthDate = birthDate;
		this.password = password;
		this.idGroup = idGroup;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(long idGroup) {
		this.idGroup = idGroup;
	}
	
}
	
	