package com.example.springdataintro.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity{

    private String firstName;
    private String lastName;

    public Author() {
    }

    public Author(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
@Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
