package com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
    private int id;
    private String name;


    public Location() {
    }

    public Location(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'';
    }
}
