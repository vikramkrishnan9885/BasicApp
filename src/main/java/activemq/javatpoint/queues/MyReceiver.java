package activemq.javatpoint.queues;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class MyReceiver {
    public static void main(String[] args) {
        try{
            //1) Create and start connection
            /*
            InitialContext ctx=new InitialContext();
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");
            QueueConnection con=f.createQueueConnection();
            */
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            InitialContext ctx=new InitialContext(props);
            ConnectionFactory f=(ConnectionFactory)ctx.lookup("ConnectionFactory");
            Connection con=f.createConnection();
            con.start();

            /*
            //2) create Queue session
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            //3) get the Queue object
            Queue t=(Queue)ctx.lookup("myQueue");
            //4)create QueueReceiver
            QueueReceiver receiver=ses.createReceiver(t);
            */

            //2) create queue session
            Session ses=con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //3) get the Queue object
            Destination t = (Destination)ctx.lookup("dynamicQueues/JCG_QUEUE");
            //QueueReceiver receiver=ses.createReceiver(t);
            MessageConsumer consumer = ses.createConsumer(t);

            //5) create listener object
            MyListener listener=new MyListener();

            //6) register the listener object with receiver
            consumer.setMessageListener(listener);

            System.out.println("Receiver1 is ready, waiting for messages...");
            System.out.println("press Ctrl+c to shutdown...");
            while(true){
                Thread.sleep(1000);
            }
        }catch(Exception e){System.out.println(e);}
    }

}