package jpahibernatedemo;

import dal.jpa.dao.EmployeesJpqlDao;
import dal.jpa.entities.Employee;
import org.testng.annotations.Test;

import java.util.List;

public class JpaHibernateDemo {

    @Test
    public void jpaReadEmployeeTest() {

        List<Employee> employeeList = EmployeesJpqlDao.readEmployeeByFirstName("Lillian");

        System.out.println("breakpoint");

    }

}
