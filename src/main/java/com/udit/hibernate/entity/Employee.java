
package com.udit.hibernate.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@Access(value = AccessType.FIELD)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_salary")
    private double salary;

    @OneToOne(mappedBy = "employee")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Address address;

    public long getId() {
        return id;
    }

    public Employee setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Employee setAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Id= " + id + ", Name= " + name + ", Salary= " + salary
                + ", {Address= " + address + "}";
    }

}
