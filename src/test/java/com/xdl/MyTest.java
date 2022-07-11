package com.xdl;

import com.xdl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

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
        people.setName("xdl");
        people.setMoney(1000.0);
        // 5、保存数据
        session.save(people);
        // 6、提交事务
        session.beginTransaction().commit();
        // 7、关闭session
        sessionFactory.close();
    }
}
