package com.xdl;

import com.xdl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        // 1、创建Configuration, 默认使用的是resource目录下的hibernate.cfg.xml，也可以通过参数修改这个值
        //Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure();
        // 2、获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3、获取Session
        Session session = sessionFactory.openSession();
        // 4、创建数据
        People people = new People();
        people.setName("李四");
        // 5、保存数据
        session.save(people);
        // 6、提交事务
        session.beginTransaction().commit();
        // 7、关闭session
        sessionFactory.close();
    }

    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        People people = session.get(People.class, 1);
        people.setMoney(3000);
        session.update(people);
        session.beginTransaction().commit();
        sessionFactory.close();
    }

    @Test
    public void test03() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from com.xdl.entity.People";
        Query query = session.createQuery(hql);
        List<People> list = query.list();
        for (People people : list) {
            System.out.println(people);
        }
        sessionFactory.close();
    }
}
