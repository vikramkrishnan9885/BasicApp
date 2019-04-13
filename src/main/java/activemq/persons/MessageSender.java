package activemq.persons;

import com.google.gson.Gson;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import person.impl.Person;

import javax.jms.*;

public class MessageSender {

    //URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String subject = "PERSONS"; // Queue Name.You can create any/many queue names as per your requirement.

    public static void main(String[] args) throws JMSException {
        // Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //Creating a non transactional session to send/receive JMS message.
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);

        //Destination represents here our queue 'JCG_QUEUE' on the JMS server.
        //The queue will be created automatically on the server.
        Destination destination = session.createQueue(subject);

        // MessageProducer is used for sending messages to the queue.
        MessageProducer producer = session.createProducer(destination);

        Person person1 = new Person(1,"Vikram","Krishnan",System.currentTimeMillis(),System.currentTimeMillis());
        Gson gson = new Gson();
        String personsJson = gson.toJson(person1);
        // We will send a small text message saying 'Hello World!!!'
        TextMessage message = session
                .createTextMessage(personsJson);

        // Here we are sending our message!
        producer.send(message);

        System.out.println("PERSONS printing@@ '" + message.getText() + "'");
        connection.close();
    }
}