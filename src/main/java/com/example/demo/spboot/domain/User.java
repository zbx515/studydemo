package com.example.demo.spboot.domain;

public class User {
    private int id;
    private String aac002;
    private String aac003;

    public User() {
    }

    public User(int id, String aac002, String aac003) {
        this.id = id;
        this.aac002 = aac002;
        this.aac003 = aac003;
    }
    public User(String aac002, String aac003) {
        this.aac002 = aac002;
        this.aac003 = aac003;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAac002() {
        return aac002;
    }

    public void setAac001(String aac002) {
        this.aac002 = aac002;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", aac001='" + aac002 + '\'' +
                ", aac003='" + aac003 + '\'' +
                '}';
    }
}
