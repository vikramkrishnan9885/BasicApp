package person.impl;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlSeeAlso(ArrayList.class)
public class Person {
    @XmlAttribute
    private int id;
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    private long createdAt;
    @XmlElement
    private long updatedAt;

    public Person(int id, String firstName, String lastName, long createdAt, long updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
