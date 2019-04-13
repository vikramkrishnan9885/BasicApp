package person.impl;

import person.interfaces.PersonDao;

import java.text.SimpleDateFormat;
import java.util.*;

public class DummyPersonDao implements PersonDao {

    private Person person1 = new Person(1,"Vikram","Krishnan",System.currentTimeMillis(),System.currentTimeMillis());
    private Person person2 = new Person(2,"Sudha","Krishnan", System.currentTimeMillis(), System.currentTimeMillis());
    private Person person3 = new Person(3,"Vasudevan","Krishnan", System.currentTimeMillis(), System.currentTimeMillis());


    private List<Person> personList = Arrays.asList(person1,person2,person3);

    public void create(Person person) {
        personList.add(person);
    }

    public Person read(int id) {
        return personList.get(id);
    }

    public List<Person> readAll() {
        return personList;
    }

    public void update(int id, Person person) {
        personList.set(id, person);
    }

    public void delete(int id) {
        personList.remove(id);
    }
}
