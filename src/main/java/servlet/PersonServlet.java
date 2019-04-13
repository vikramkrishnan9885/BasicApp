package servlet;

import person.Persons;
import person.impl.DummyPersonDao;
import person.impl.Person;
import person.interfaces.PersonDao;
import serde.PersonSerde;
import serde.PersonSerdeImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(
        name="PersonServlet",
        urlPatterns = "/person/*"
)
public class PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonDao personDao = new DummyPersonDao();

        PersonSerde personSerde = new PersonSerdeImpl();

        ServletOutputStream out = resp.getOutputStream();

        String pathInfo = req.getPathInfo();

        if(pathInfo == null || pathInfo.equals("/")) {
            List<Person> personList=null;
			try {
				personList = personDao.readAll();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Persons persons = new Persons(personList);
            String personsXml = personSerde.serialize(persons);
            out.write(personsXml.getBytes());
            out.flush();
            out.close();
        } else  {
            String[] splits = pathInfo.split("/");
            if(splits.length != 2) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            String stringId = splits[1];
            int id = Integer.valueOf(stringId);
            Person person = personDao.read(id);
            String personXml = personSerde.serialize(person);
            out.write(personXml.getBytes());
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
