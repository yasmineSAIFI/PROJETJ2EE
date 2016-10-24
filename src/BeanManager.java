package beans;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import dao.Group;
import dao.Person;
import idao.PersonDao;

public class BeanManager implements PersonDao {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/annuaire";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	@Override
	public Collection<Group> findAllGroups() {
		ArrayList<Group> listGroups = new ArrayList<Group>();
		java.sql.Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery("select * from group where idGroup");
			while (rs.next()) {
				int idPerson = rs.getInt("idPerson");
				String nomGroup = rs.getString("nomGroup");
				long idGroup = rs.getLong("idGroup");

				Group g = new Group(nomGroup, idGroup);

				listGroups.add(g);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return listGroups;
	}

	@Override
	public Collection<Person> findAllPersons(long groupId) {
		ArrayList<Person> listPersons = new ArrayList<Person>();
		java.sql.Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery("select * from person where idGroup = " + groupId);
			while (rs.next()) {
				long idPerson = rs.getLong("idPerson");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String mail = rs.getString("mail");
				String webSite = rs.getString("webSite");
				Date birthDate = rs.getDate("birthDate");
				String password = rs.getString("password");
				long idGroup = rs.getLong("idGroup");
				Person p = new Person(idPerson, firstName, lastName, mail, webSite, birthDate, password, idGroup);
				listPersons.add(p);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return listPersons;
	}

	@Override
	public Person findPerson(long id) {
		Person person = null;
		java.sql.Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery("select * from person where idPerson = " + id);
			while (rs.next()) {
				long idPerson = rs.getLong("idPerson");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String mail = rs.getString("mail");
				String webSite = rs.getString("webSite");
				Date birthDate = rs.getDate("birthDate");
				String password = rs.getString("password");
				long idGroup = rs.getLong("idGroup");
				person = new Person(idPerson, firstName, lastName, mail, webSite, birthDate, password, idGroup);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return person;
	}

	@Override
	public void savePerson(Person p) {

		java.sql.Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			String sql;
			sql = "INSERT INTO PERSON(firstName,LastName,mail,webSite,birthDate,password) VALUES(?,?,?,?,?,?)";

			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setString(0, p.getFirstName());
			ps1.setString(1, p.getLastName());
			ps1.setString(2, p.getMail());
			ps1.setString(3, p.getWebSite());
			ps1.setDate(4, new java.sql.Date(p.getBirthDate().getTime()));
			ps1.setString(5, p.getPassword());

			ps1.executeUpdate();
			ps1.close();

			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

	}

	@Override
	public void saveGroup(Group g) {
		java.sql.Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			String sql;
			sql = "INSERT INTO GROUP(nomGroup) VALUES(?)";

			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setString(0, g.getNomGroup());

			ps1.executeUpdate();
			ps1.close();

			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

	}

}
