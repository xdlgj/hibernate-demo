package com.xdl;

import com.xdl.entity.Customer;
import com.xdl.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class MyTest05 {
    @Test
    public void test01() {
        // 1、创建Configuration, 默认使用的是resource目录下的hibernate.cfg.xml，也可以通过参数修改这个值
        Configuration configuration = new Configuration().configure();
        // 2、获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3、获取Session
        Session session = sessionFactory.openSession();
        Orders orders = session.get(Orders.class, 1);
        System.out.println(orders);
        // 关闭session
        sessionFactory.close();
    }
    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Orders orders = session.get(Orders.class, 1);
        System.out.println(orders.getCustomer());
        sessionFactory.close();
    }
}
