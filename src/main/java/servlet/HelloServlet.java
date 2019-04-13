package servlet;

import com.google.gson.Gson;
import person.Persons;
import person.impl.DummyPersonDao;
import person.impl.Person;
import person.interfaces.PersonDao;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

@WebServlet(
        name = "HelloServlet",
        urlPatterns = {"/hello"}
)
public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();

        String paramName = "id";


        if (req.getParameter(paramName) == null) {
            PersonDao personDao = new DummyPersonDao();
            //List<Person> personList = personDao.readAll();
            //Gson gson = new Gson();
            //String personsJson = gson.toJson(personList);
            //out.write(personsJson.getBytes());
            //out.flush();
            //out.close();
            //creating the JAXB context
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(Persons.class);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            //creating the marshaller object
            Marshaller marshaller = null;
            try {
                marshaller = jaxbContext.createMarshaller();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            //setting the property to show xml format output
            try {
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            } catch (PropertyException e) {
                e.printStackTrace();
            }
            //setting the values in POJO class
            //Person p1 = personDao.read(1);
            List<Person> personList=null;
			try {
				personList = personDao.readAll();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            Persons persons = new Persons(personList);
            StringWriter stringWriter = new StringWriter();
            //calling the marshall method
            try {
                marshaller.marshal(persons, stringWriter);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            String p1Xml = stringWriter.toString();


            //out.write(p1Json.getBytes());
            //out.write("hello heroku".getBytes());
            out.write(p1Xml.getBytes());
            out.flush();
            out.close();

        } else {
            int idParam = Integer.valueOf(req.getParameter(paramName));
            PersonDao personDao = new DummyPersonDao();
            //Person p1 = personDao.read(idParam);
            //Gson gson = new Gson();
            //String p1Json = gson.toJson(p1);

            //creating the JAXB context
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(Person.class);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            //creating the marshaller object
            Marshaller marshaller = null;
            try {
                marshaller = jaxbContext.createMarshaller();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            //setting the property to show xml format output
            try {
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            } catch (PropertyException e) {
                e.printStackTrace();
            }
            //setting the values in POJO class
            //Person p1 = personDao.read(1);
            Person p1 = personDao.read(idParam);
            StringWriter stringWriter = new StringWriter();
            //calling the marshall method
            try {
                marshaller.marshal(p1, stringWriter);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            String p1Xml = stringWriter.toString();


            //out.write(p1Json.getBytes());
            //out.write("hello heroku".getBytes());
            out.write(p1Xml.getBytes());
            out.flush();
            out.close();
        }


    }
}