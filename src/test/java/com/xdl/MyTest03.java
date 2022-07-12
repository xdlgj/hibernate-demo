package com.xdl;

import com.xdl.entity.Account;
import com.xdl.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyTest03 {
    @Test
    public void test01() {
        // 1、创建Configuration, 默认使用的是resource目录下的hibernate.cfg.xml，也可以通过参数修改这个值
        Configuration configuration = new Configuration().configure();
        // 2、获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3、获取Session
        Session session = sessionFactory.openSession();
        // 4、创建数据
        Account account = new Account();
        account.setName("张三");
        Course course = new Course();
        course.setName("Java");
        // 建立关联关系， 如果不建立关联关系可以添加记录，但是外键cid为空
        Set<Course> courses = new HashSet<>();
        courses.add(course);
        account.setCourses(courses);
        // 5、保存数据, 两个对象都需要保存
        session.save(course);
        session.save(account);
        // 6、提交事务
        session.beginTransaction().commit();
        // 7、关闭session
        sessionFactory.close();
    }
}
