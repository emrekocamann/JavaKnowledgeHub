package com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="employees")
public class EmployeeListWrapper {
     private List<Employee> employees;

     @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return
                "employees=" + employees;
    }
}
