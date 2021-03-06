package jpahibernatedemo;

import dal.jpa.dao.EmployeesJpaDao;
import dal.jpa.dao.EmployeesJpqlDao;
import dal.jpa.entities.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class JpaDemo {

    private DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // CREATE
    @Test
    public void createEmployeeJpaTest() throws ParseException {
        Date birthDate = simpleDateFormat.parse("1980-2-22");
        String firstName = "Demo_Employee";
        String lastName = "Jpa_Persist";
        String gender = "F";
        Date hireDate = simpleDateFormat.parse("2015-5-15");

        int employeeNumber = EmployeesJpaDao.persistEmployee(birthDate, firstName, lastName, gender, hireDate);

        Employee createdEmployee = EmployeesJpaDao.findEmployee(employeeNumber);
        System.out.println("The following employee was created");
        System.out.println(createdEmployee);

        Assert.assertEquals(createdEmployee.getEmpNo(), employeeNumber, "employeeNumber is not correct in database.");
        Assert.assertEquals(createdEmployee.getBirthDate(), birthDate, "birthDate is not correct in database.");
        Assert.assertEquals(createdEmployee.getFirstName(), firstName, "firstName is not correct in database.");
        Assert.assertEquals(createdEmployee.getLastName(), lastName, "lastName is not correct in database.");
        Assert.assertEquals(createdEmployee.getGender(), gender, "gender is not correct in database.");
        Assert.assertEquals(createdEmployee.getHireDate(), hireDate, "hireDate is not correct in database.");

    }

    // READ
    @Test
    public void readEmployeeJpaTest() throws ParseException {
        Date birthDate = simpleDateFormat.parse("1993-3-13");
        String firstName = "Demo_Employee";
        String lastName = "Jpa_Find";
        String gender = "M";
        Date hireDate = simpleDateFormat.parse("2012-12-21");

        int employeeNumber = EmployeesJpaDao.persistEmployee(birthDate, firstName, lastName, gender, hireDate);

        Employee employee = EmployeesJpaDao.findEmployee(employeeNumber);
        System.out.println("Read employee");
        System.out.println(employee);

        Assert.assertEquals(employee.getEmpNo(), employeeNumber, "Employee Number is wrong in database;");
        Assert.assertEquals(employee.getBirthDate(), birthDate, "Birth Date is wrong in database;");
        Assert.assertEquals(employee.getFirstName(), firstName, "First Name is wrong in database;");
        Assert.assertEquals(employee.getLastName(), lastName, "Last Name is wrong in database;");
        Assert.assertEquals(employee.getGender(), gender, "Gender is wrong in database;");
        Assert.assertEquals(employee.getHireDate(), hireDate, "Hire Date is wrong in database;");
    }

    // UPDATE
    @Test
    public void updateEmployeeJpaTest() {
        Random random = new Random();
        String newLastName = "Jooq_Update_" + random.nextInt(100);
        int employeeNumber = EmployeesJpqlDao.getLastEmployeeNumber();
        Employee employeeToUpdate = EmployeesJpaDao.findEmployee(employeeNumber);
        System.out.println("employeeToUpdate");
        System.out.println(employeeToUpdate);

        employeeToUpdate.setLastName(newLastName);
        EmployeesJpaDao.updateEmployee(employeeNumber, employeeToUpdate);

        Employee updatedEmployee = EmployeesJpaDao.findEmployee(employeeNumber);

        System.out.println("updatedEmployee");
        System.out.println(updatedEmployee);

        Assert.assertEquals(updatedEmployee.getLastName(), newLastName, "The last name of employee was not updated.");

    }

    // DELETE
    @Test
    public void deleteEmployeeJpaTest() {
        int employeeNumber = EmployeesJpqlDao.getLastEmployeeNumber();
        System.out.println("The following employee will be deleted from database");
        System.out.println(EmployeesJpqlDao.selectEmployeeWhereEmployeeNumber(employeeNumber));

        EmployeesJpaDao.removeEmployee(employeeNumber);

        Assert.assertTrue(!EmployeesJpaDao.isEmployeeInDatabase(employeeNumber));
    }

}
