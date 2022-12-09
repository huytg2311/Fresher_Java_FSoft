package com.example.pa101.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Member {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime update_Time;

    public Member() {
    }

    public Member(int id, String firstName, String lastName, String phone, String email, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Member(int id, String firstName, String lastName, String username, String password, String phone, String email, String description, LocalDateTime createDate, LocalDateTime update_Time) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.createDate = createDate;
        this.update_Time = update_Time;
    }

    public Member(String firstname, String lastname, String email, String phone, String description, String username) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdate_Time() {
        return update_Time;
    }

    public void setUpdate_Time(LocalDateTime update_Time) {
        this.update_Time = update_Time;
    }
}
