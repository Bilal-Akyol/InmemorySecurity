package com.securitydemo.inmemory.users;

public class Teacher extends Person{
    private String departmant;

    public Teacher(Long id, String name, String surname, String departmant) {
        super(id, name, surname);
        this.departmant = departmant;
    }

    public Teacher(String departmant) {
        this.departmant = departmant;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }
}
