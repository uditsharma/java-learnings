package com.udit.jackson.jsonignore;

public class MyTestClass {
    private long id;
    private String name;
    private String notInterstingMember;
    private int anotherMember;
    private int forgetThisField;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotInterstingMember() {
        return this.notInterstingMember;
    }

    public void setNotInterstingMember(String notInterstingMember) {
        this.notInterstingMember = notInterstingMember;
    }

    public int getAnotherMember() {
        return this.anotherMember;
    }

    public void setAnotherMember(int anotherMember) {
        this.anotherMember = anotherMember;
    }

    public int getForgetThisField() {
        return this.forgetThisField;
    }

    public void setForgetThisField(int forgetThisField) {
        this.forgetThisField = forgetThisField;
    }
}
