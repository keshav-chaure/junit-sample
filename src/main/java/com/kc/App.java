package com.kc;

import com.kc.dto.FileBean;
import com.kc.dto.Order;
import com.kc.exception.OrderException;
import com.kc.service.OrderBO;
import com.kc.service.OrderBOImpl;

import java.util.ArrayList;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        OrderBO orderBO=new OrderBOImpl();
        Order order=new Order(1,1);

        try {
            orderBO.placeOrder(order);
        } catch (OrderException e) {
            e.printStackTrace();
        }

        System.out.println( "Hello World!" );
        ArrayList<FileBean> listFb=new ArrayList<FileBean>();
        listFb.add(new FileBean(1,"abc",1,"abc"));
        listFb.add(new FileBean(5,"abc",5,"abc"));
        listFb.add(new FileBean(6,"abc",6,"abc"));
        listFb.add(new FileBean(2,"abc",2,"abc"));
        listFb.add(new FileBean(3,"abc",3,"abc"));
        listFb.add(new FileBean(4,"abc",4,"abc"));
        System.out.println(listFb);
        sort(listFb);
        System.out.println(listFb);
        reverse(listFb);
        System.out.println(listFb);
    }
}
