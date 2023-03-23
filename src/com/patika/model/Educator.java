package com.patika.model;

public class Educator extends User
{
    public Educator(int id, String name, String surname, String username, String password) {
        super(id, name, surname, username, password, Role.EDUCATOR);
    }

    public Educator() {
    }
}
