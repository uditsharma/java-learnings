package com.udit.hibernate;

import com.udit.hibernate.config.HibernateConfig;
import com.udit.hibernate.dao.IPersonDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring4Hibernate4Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(HibernateConfig.class);
        ctx.refresh();
        IPersonDao pdao = ctx.getBean(IPersonDao.class);
        pdao.savePerson();
        System.out.println("Done");
    }

}