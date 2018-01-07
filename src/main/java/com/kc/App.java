package com.kc;

import com.kc.exception.OrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */

public class App {


    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws OrderException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-Module.xml");

        /*
        EmployeeService app = context.getBean(EmployeeServiceImpl.class);
        app.insertEmployeeUsingEmployeeId("one");
        */
        MyXMLApplicationClient client = context.getBean(MyXMLApplicationClient.class);
        client.processRequests();
       // client.uploadToS3();


        // close the context
        context.close();



/*


        Order order = new Order(1, 1);

        try {
            orderBO.placeOrder(order);
        } catch (OrderException e) {
            e.printStackTrace();
        }

        logger.info("in Main!!");
        logger.debug("In Main...");

        ArrayList<FileBean> listFb = new ArrayList<FileBean>();
        listFb.add(new FileBean(1, "abc", 1, "abc"));
        listFb.add(new FileBean(5, "abc", 5, "abc"));
        listFb.add(new FileBean(6, "abc", 6, "abc"));
        listFb.add(new FileBean(2, "abc", 2, "abc"));
        listFb.add(new FileBean(3, "abc", 3, "abc"));
        listFb.add(new FileBean(4, "abc", 4, "abc"));
        System.out.println(listFb);
        sort(listFb);
        System.out.println(listFb);
        reverse(listFb);
        System.out.println(listFb);
        */
    }


}
