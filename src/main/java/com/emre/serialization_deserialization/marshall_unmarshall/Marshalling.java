package com.emre.serialization_deserialization.marshall_unmarshall;

import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.Department;
import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.Employee;
import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.EmployeeListWrapper;
import com.emre.serialization_deserialization.marshall_unmarshall.employeeEntity.Location;
import com.emre.utilities.JdbcConnection;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Marshalling {

    //                marshalling
    //Java Object ------------------> XML File

    public static void main(String[] args) {
        Marshalling marshalling = new Marshalling();
        EmployeeListWrapper employeeListWrapper =  new EmployeeListWrapper();
        employeeListWrapper.setEmployees(marshalling.getEmployeeListFromDatabase());
        marshalling.createXmlFile(employeeListWrapper);
    }

    public  List<Employee> getEmployeeListFromDatabase() {

        Employee employee;
        List<Employee> employees = new ArrayList<>();
        EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
        employeeListWrapper.setEmployees(employees);
        ResultSet resultSet = JdbcConnection.executeQuery("select id, first_name, last_name, e.department_id, " +
                "department_name,e.location_id, location_name\n" +
                "from employee e \n" +
                "join location l\n" +
                "on e.location_id = l.location_id\n" +
                "join department d\n" +
                "on e.department_id =d.department_id");

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int deptId = resultSet.getInt("department_id");
                String deptName = resultSet.getString("department_name");
                int locationId = resultSet.getInt("location_id");
                String locationName = resultSet.getString("location_name");

                employee = new Employee(id, firstName, lastName, new Department(deptId, deptName), new Location(locationId, locationName));
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcConnection.closeConnection();
        }
        return employees;
    }

    public void createXmlFile(EmployeeListWrapper employeeListWrapper){
        try {
            File file = new File("C:\\Users\\emrek\\Documents\\Kraft\\employeeList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeListWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(employeeListWrapper, file);
            marshaller.marshal(employeeListWrapper, System.out);
            System.out.println("Xml file was created");
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
