package com.example.myapplication;

public class Session_gv {
    private int session;
    private String subject;
    private String classroom;
    private String group;


    public Session_gv(int seesion, String subject, String classroom, String group) {
        this.session = seesion;
        this.subject = subject;
        this.classroom = classroom;
        this.group = group;
    }

    public int getSeesion() {
        return session;
    }

    public void setSeesion(int seesion) {
        this.session = seesion;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
