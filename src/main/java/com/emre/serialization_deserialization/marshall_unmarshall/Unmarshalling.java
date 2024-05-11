package com.emre.serialization_deserialization.marshall_unmarshall;

import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.Employee;
import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.EmployeeListWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Unmarshalling {

    //              unmarshalling
    //XML File ----------------------> Java Object


    public static void main(String[] args) {
        File file = new File("C:\\Users\\emrek\\Documents\\Kraft\\employeeList.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeListWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            EmployeeListWrapper employeeListWrapper =(EmployeeListWrapper) unmarshaller.unmarshal(file);
            for (Employee employee : employeeListWrapper.getEmployees()) {
                System.out.println(employee.toString());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
