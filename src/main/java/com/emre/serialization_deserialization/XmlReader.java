package com.emre.serialization_deserialization;

import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.Employee;
import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.EmployeeListWrapper;
import com.emre.serialization_deserialization.marshall_unmarshall.customerEntity.Customer;
import com.emre.serialization_deserialization.marshall_unmarshall.customerEntity.CustomerListWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public  class XmlReader {

    public static <T> T read(String xmlFilePath, String classReference) {

        File file = new File(xmlFilePath);
        T classType = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Class.forName(classReference));
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            classType = (T) jaxbUnMarshaller.unmarshal(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return classType;
    }



    public static void main(String[] args) {
        // example - 1
        String filePath = "C:\\Users\\emrek\\Documents\\Kraft\\employeeList.xml";
        String classReference = "com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.EmployeeListWrapper";

        EmployeeListWrapper employeeListWrapper = (EmployeeListWrapper)XmlReader.read(filePath,classReference);

        for (Employee employee : employeeListWrapper.getEmployees()) {
            System.out.println("First Name = " + employee.getFirstName()+"\n"+
                    "Last Name = "+employee.getLastName()+"\n"+
                    "Department = " + employee.getDepartment().getName()+"\n"+
                    "Location = "+employee.getLocation().getName()+"\n");
        }

        System.out.println("-------------------------------");
        // example - 2
        filePath = "C:\\Users\\emrek\\Documents\\Kraft\\customerList.xml";
        classReference ="com.emre.serialization_deserialization.marshall_unmarshall.entity.CustomerListWrapper";

        CustomerListWrapper customerListWrapper = XmlReader.read(filePath,classReference);

        for (Customer customer : customerListWrapper.getCustomers()) {
            System.out.println("id: "+customer.getId() + "\n"+
                    "name: " + customer.getName()+"\n" +
                    "age: "+customer.getAge() +"\n"+
                    "job: "+customer.getJob());
        }

    }





}
