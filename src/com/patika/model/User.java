package com.patika.model;

import com.patika.Helper.Helper;

public class User
{
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Role role;
    public User(int id, String name, String surname, String username, String password, Role role) {
        setId(id);
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public User() {
    }
}
