package person;

import person.impl.Person;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlRootElement(name="persons")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Person.class})
public class Persons {
    @XmlElement(name = "person")
    private List<Person> persons = null;

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public Persons(){}

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
