package sqlite;

import java.awt.List;
import java.sql.SQLException;

import person.impl.Person;
import person.impl.SqlitePersonDao;
import person.interfaces.PersonDao;

public class SqliteTest {
	public static void main(String[] args) {
		PersonDao personDao = new SqlitePersonDao();
		Person person1 = new Person(1,"Vikram","Krishnan",System.currentTimeMillis(),System.currentTimeMillis());
	    Person person2 = new Person(2,"Sudha","Krishnan", System.currentTimeMillis(), System.currentTimeMillis());
	    Person person3 = new Person(3,"Vasudevan","Krishnan", System.currentTimeMillis(), System.currentTimeMillis());
	    try {
			personDao.create(person1);
			personDao.create(person2);
			personDao.create(person3);
			 java.util.List<Person> persons = personDao.readAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
