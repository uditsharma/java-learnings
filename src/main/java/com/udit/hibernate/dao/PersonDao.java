package com.udit.hibernate.dao;

import com.udit.hibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonDao implements IPersonDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void savePerson() {
        Person person = new Person();
        person.setId(1);
        person.setName("Ram");
        hibernateTemplate.save(person);
    }
}