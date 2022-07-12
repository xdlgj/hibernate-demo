package com.xdl;

import com.xdl.entity.Account;
import com.xdl.entity.Course;
import com.xdl.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyTest04 {
    @Test
    public void test01() {
        // 1、创建Configuration, 默认使用的是resource目录下的hibernate.cfg.xml，也可以通过参数修改这个值
        Configuration configuration = new Configuration().configure();
        // 2、获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3、获取Session
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer);
        // 关闭session
        sessionFactory.close();
    }
    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer.getOrders().size());
        sessionFactory.close();
    }
}
