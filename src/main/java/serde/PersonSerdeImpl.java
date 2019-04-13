package serde;

import person.Persons;
import person.impl.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class PersonSerdeImpl implements PersonSerde{
    public String serialize(Person person) {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(person,stringWriter);
        } catch (JAXBException e){
            e.printStackTrace();
        }
        String personToXml = stringWriter.toString();
        return personToXml;
    }

    public String serialize(Persons persons) {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons,stringWriter);
        } catch (JAXBException e){
            e.printStackTrace();
        }
        String personsToXml = stringWriter.toString();
        return personsToXml;
    }
}
