package com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Department department;
    private Location location;


    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, Department department, Location location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.location = location;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", location=" + location;
    }
}
