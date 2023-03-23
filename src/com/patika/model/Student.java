package com.patika.model;

public class Student extends User
{
    public Student(int id, String name, String surname, String username, String password) {
        super(id, name, surname, username, password, Role.STUDENT);
    }

    public Student() {
    }
}
