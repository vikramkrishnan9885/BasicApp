package person.interfaces;

import person.impl.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    public void create(Person person) throws SQLException, ClassNotFoundException;
    public Person read(int id);
    public List<Person> readAll() throws ClassNotFoundException, SQLException;
    public void update(int id, Person person);
    public void delete(int id);
}
