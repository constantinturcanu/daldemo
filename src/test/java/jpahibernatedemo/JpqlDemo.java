package jpahibernatedemo;

import dal.jpa.dao.EmployeesJpqlDao;
import dal.jpa.entities.Employee;
import org.testng.annotations.Test;

import java.util.List;

public class JpqlDemo {

    // CREATE
    @Test
    public void createEmployeeJpqlTest() {

    }

    // READ
    @Test
    public void readEmployeeJpqlTest() {
        List<Employee> employeeList = EmployeesJpqlDao.selectEmployeeByFirstName("Lillian");
        String lastname = employeeList.get(0).getLastName();
        System.out.println("lastname = " + lastname);
        List<Employee> employeeList2 = EmployeesJpqlDao.selectEmployeeByFirstNameAndLastName("Lillian", "Haddadi");
        System.out.println(employeeList2.get(0));
    }

    // UPDATE
    @Test
    public void updateEmployeeJpqlTest() {

    }

    // DELETE
    @Test
    public void deleteEmployeeJpqlTest() {

    }

}
