package person.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import person.interfaces.PersonDao;

public class SqlitePersonDao implements PersonDao {

	public void create(Person person) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("create table if not exists persons (id, first_name, last_name, created_at, updated_at);");
        PreparedStatement prep = conn.prepareStatement("insert into persons values (?, ?, ?, ?, ?);");
        prep.setInt(1, person.getId());
        prep.setString(2, person.getFirstName());
        prep.setString(3, person.getLastName());
        prep.setLong(4, System.currentTimeMillis());
        prep.setLong(5, System.currentTimeMillis());
        int i= prep.executeUpdate();  
        System.out.println(i+" records inserted");      
        conn.close(); 
	}

	public Person read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> readAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement st = conn.createStatement();
      //reading records
        System.out.println("Reading records:");
        ResultSet rs=st.executeQuery("select * from persons");

        while(rs.next()){
            System.out.println("First Name: "+rs.getString("first_name")+" Last Name: "+rs.getString("last_name"));
        }
        rs.close();
        st.close();
        conn.close();
		return null;
	}

	public void update(int id, Person person) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
