package serde;

import person.Persons;
import person.impl.Person;

public interface PersonSerde {
    public String serialize(Person person);
    public String serialize(Persons persons);
}

