package com.example.jeffmathew.caroscope.model;

/**
 * Created by Jeff Mathew on 28-08-2016.
 */
public class car {
    private int id;
    private String name;
    private String company;

    public car(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
