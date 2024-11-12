package Reflection0702;
//package edu.pnu.model;

public class User {
    private Long id;
    private String username;
    private int age;

    public User(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}
