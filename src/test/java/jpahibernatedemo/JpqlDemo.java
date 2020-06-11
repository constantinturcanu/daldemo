package jpahibernatedemo;

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

public class JpqlDemo {

    private DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // CREATE
    @Test
    public void createEmployeeJpqlTest() throws ParseException {
        Date birthDate = simpleDateFormat.parse("1990-1-30");
        String firstName = "Demo_Employee";
        String lastName = "Jpql_Create";
        String gender = "F";
        Date hireDate = simpleDateFormat.parse("2020-6-10");

        int createdEmployeeNumber = EmployeesJpqlDao.insertEmployee(birthDate, firstName, lastName, gender, hireDate);

        Employee actualEmployee = EmployeesJpqlDao.selectEmployeeWhereEmployeeNumber(createdEmployeeNumber);

        Assert.assertNotNull(actualEmployee, "The employee was not created successfully in database.");
    }

    // READ
    @Test
    public void readEmployeeJpqlTest() {
        String firstName = "Lillian";
        String lastName = "Haddadi";

        List<Employee> foundEmployees = EmployeesJpqlDao.selectEmployeeWhereFirstNameAndLastName(firstName, lastName);

        Assert.assertTrue(foundEmployees.size() > 0,
                String.format("Found no employee named %s %s.", firstName, lastName) );
    }

    // UPDATE
    @Test
    public void updateEmployeeJpqlTest() {
        int lastEmployeeNumber = EmployeesJpqlDao.getLastEmployeeNumber();
        Employee lastAddedEmployee = EmployeesJpqlDao.selectEmployeeWhereEmployeeNumber(lastEmployeeNumber);
        System.out.println("lastAddedEmployee");
        System.out.println(lastAddedEmployee);

        Random random = new Random();
        String newLastName = "Jooq_Update_" + random.nextInt(100);

        EmployeesJpqlDao.updateEmployeeLastNameWhereFirstNameAndLastName(
                lastAddedEmployee.getFirstName(),
                lastAddedEmployee.getLastName(),
                newLastName);

        Employee updatedEmployee = EmployeesJpqlDao.selectEmployeeWhereEmployeeNumber(lastEmployeeNumber);

        System.out.println("updatedEmployee");
        System.out.println(updatedEmployee);

        Assert.assertEquals(updatedEmployee.getLastName(), newLastName,
                "The last_name column was not updated for employee.");

    }

    // DELETE
    @Test
    public void deleteEmployeeJpqlTest() {
        int lastEmployeeNumber = EmployeesJpqlDao.getLastEmployeeNumber();
        int deletedRowsCount = EmployeesJpqlDao.deleteEmployeeWhereEmployeeNumber(lastEmployeeNumber);

        Assert.assertEquals(deletedRowsCount, 1, "No rows were deleted.");
        Assert.assertTrue(!EmployeesJpqlDao.isEmployeeInDatabaseByEmployeeNumber(lastEmployeeNumber),
                "Employee with employeeNumber " + lastEmployeeNumber + " still exists in database.");
    }

}
