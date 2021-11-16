package com.example.myapplication.model;

public class User {
    private String id;
    private String usename;
    private String pass;
    private int role;

    public  User(){}

    public User(String id, String usename, String pass, int role) {
        this.id = id;
        this.usename = usename;
        this.pass = pass;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
