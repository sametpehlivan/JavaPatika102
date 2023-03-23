package com.patika.model;

public class Operator extends User
{
    public Operator(int id, String name, String surname, String username, String password) {
        super(id, name, surname, username, password, Role.OPERATOR);
    }

    public Operator() {
    }
}
