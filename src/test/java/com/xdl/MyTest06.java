package com.xdl;

import com.xdl.entity.Customer;
import com.xdl.entity.Orders;
import com.xdl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class MyTest06 {
    /**
     * 查询数据表中的所有数据
     */
    @Test
    public void test01() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from People";
        Query query = session.createQuery(hql);
        List<People> peoples = query.list();
        for(People people: peoples) {
            System.out.println(people);
        }
        // 关闭session
        sessionFactory.close();
    }

    /**
     * 分页查询
     */
    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from People";
        Query query = session.createQuery(hql);
        query.setFirstResult(1); // 默认从第一条数据开始
        query.setMaxResults(2);
        List<People> peoples = query.list();
        for(People people: peoples) {
            System.out.println(people);
        }
        sessionFactory.close();
    }
    /**
     * where条件查询
     */
    @Test
    public void test03() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from People where id = 1";
        Query query = session.createQuery(hql);
        // 如果没有查询到数据则会抛出异常：java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        // People people = (People) query.list().get(0);
        People people = (People) query.uniqueResult(); // 如果没有查询到数据在返回null
        System.out.println(people);
    }
    /**
     * 模糊查询
     */
    @Test
    public void test04() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from People where name like '%三%'";
        Query query = session.createQuery(hql);
        List<People> peoples = query.list();
        for(People people: peoples) {
            System.out.println(people);
        }
    }
    /**
     * 排序
     */
    @Test
    public void test05() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        // String hql = "from People order by id"; // asc升序
        String hql = "from People order by id desc"; // desc升序
        Query query = session.createQuery(hql);
        List<People> peoples = query.list();
        for(People people: peoples) {
            System.out.println(people);
        }
    }
    /**
     * 只查询用户名
     */
    @Test
    public void test06() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "select name from People";
        Query query = session.createQuery(hql);
        List<String> names = query.list();
        for(String name: names) {
            System.out.println(name);
        }
    }
    /**
     * 占位符
     */
    @Test
    public void test07() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from People where name = :name";
        Query query = session.createQuery(hql);
        query.setString("name", "xdl");
        List<People> peoples = query.list();
        for(People people: peoples) {
            System.out.println(people);
        }
    }

    /**
     * 级联查询
     */
    @Test
    public void test08() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql1 = "from Customer where id = :id";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("id", 1);
        Customer customer = (Customer) query1.uniqueResult();
        System.out.println(customer);
        String hql2 = "from Orders where customer = :customer";
        Query query2 = session.createQuery(hql2);
        query2.setEntity("customer", customer);
        List<Orders> orders = query2.list();
        for(Orders order: orders) {
            System.out.println(order);
        }
    }
}
