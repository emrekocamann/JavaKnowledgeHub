package com.emre.serialization_deserialization.marshall_unmarshall.customerEntity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customerList")
public class CustomerListWrapper {

    private List<Customer> customers;

    @XmlElement(name ="customer")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return  "customers=" + customers ;
    }
}
