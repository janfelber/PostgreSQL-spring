package com.example.app.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "user", schema = "app")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "create_date")
    private Date create_date;

    @PrePersist
    protected void onCreate() {
        create_date = new Date();
    }

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "surname")
    private String surname;

    @NotEmpty
    @Column(name = "status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }




}
