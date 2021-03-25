package com.uniamerica.avaliation.model;

import javax.persistence.*;

@Entity
@Table(name="vehicles")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String  registration;
    private int year;

    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicle(int year, String registration) {
        this.year = year;
        this.registration = registration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
