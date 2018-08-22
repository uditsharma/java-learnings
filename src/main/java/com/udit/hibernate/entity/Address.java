package com.udit.hibernate.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
@Access(value = AccessType.FIELD)
public class Address {

    @Id
    @Column(name = "emp_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = {@Parameter(name = "property", value = "employee")})
    private long id;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee employee;

    //Getter setter methods

    public long getId() {
        return id;
    }

    public Address setId(long id) {
        this.id = id;
        return this;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public Address setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Address setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Address setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    @Override
    public String toString() {
        return "AddressLine1= " + addressLine1 + ", City=" + city
                + ", Zipcode=" + zipcode;
    }
}
