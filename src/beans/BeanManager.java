package beans;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> findAllPersons(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findPerson(long id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

}
