package com.emre.serialization_deserialization.marshall_unmarshall.customerEntity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private int id;
    private String name;
    private int age;
    private Job job;

    public Customer() {
    }

    public Customer(int id, String name, int age, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job=" + job +
                '}';
    }
}
