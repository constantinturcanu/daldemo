package jooqdemo;

import dal.jooq.dao.EmployeesJooqDao;
import dal.jooq.entities.enums.EmployeesGender;
import dal.jooq.entities.tables.records.EmployeesRecord;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Random;

public class JooqDemo {

    // CREATE
    @Test
    public void createEmployeeJooqTest() {
        Integer employeeNumber = EmployeesJooqDao.getNextAvailableEmployeeNumber();
        LocalDate birthDate = LocalDate.of(1979, 8, 24);
        String firstName = "Demo_Employee";
        String lastName = "Jooq_Create";
        EmployeesGender gender = EmployeesGender.M;
        LocalDate hireDate = LocalDate.of(1969, 7, 27);

        EmployeesJooqDao.storeEmployee(
                employeeNumber,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate);

        EmployeesRecord createdEmployee = EmployeesJooqDao.selectEmployeeByEmployeeNumber(employeeNumber);

        System.out.println("createdEmployee");
        System.out.println(createdEmployee);

        Assert.assertEquals(createdEmployee.getEmpNo(), employeeNumber, "employeeNumber is not correctly stored in database.");
        Assert.assertEquals(createdEmployee.getBirthDate(), birthDate, "birthDate is not correctly stored in database.");
        Assert.assertEquals(createdEmployee.getFirstName(), firstName, "firstName is not correctly stored in database.");
        Assert.assertEquals(createdEmployee.getLastName(), lastName, "lastName is not correctly stored in database.");
        Assert.assertEquals(createdEmployee.getGender(), gender, "gender is not correctly stored in database.");
        Assert.assertEquals(createdEmployee.getHireDate(), hireDate, "hireDate is not correctly stored in database.");

    }

    // READ
    @Test
    public void readEmployeeJooqTest() {
        Integer employeeNumber = EmployeesJooqDao.getLastEmployeeNumber();
        EmployeesRecord lastCreatedEmployee = EmployeesJooqDao.selectEmployeeByEmployeeNumber(employeeNumber);

        System.out.println("lastCreatedEmployee");
        System.out.println(lastCreatedEmployee);

        Assert.assertEquals(lastCreatedEmployee.getEmpNo(), employeeNumber, "employeeNumber is not correctly stored in database.");
    }

    // UPDATE
    @Test
    public void updateEmployeeJooqTest() {
        Integer employeeNumber = EmployeesJooqDao.getLastEmployeeNumber();
        EmployeesRecord employeeToUpdate = EmployeesJooqDao.selectEmployeeByEmployeeNumber(employeeNumber);
        System.out.println("employeeToUpdate");
        System.out.println(employeeToUpdate);

        Random random = new Random();
        String newLastName = "Jooq_Update_" + random.nextInt(100);
        int updatedRowsCount = EmployeesJooqDao.updateEmployeeLastNameWhereEmployeeNumber(employeeNumber, newLastName);
        EmployeesRecord updatedEmployee = EmployeesJooqDao.selectEmployeeByEmployeeNumber(employeeNumber);
        System.out.println("updatedEmployee");
        System.out.println(updatedEmployee);

        Assert.assertEquals(updatedRowsCount, 1, "Unexpected number of updated rows.");
        Assert.assertEquals(updatedEmployee.getLastName(), newLastName, "Employee last name was not updated in database.");
    }

    // DELETE
    @Test
    public void deleteEmployeeJooqTest() {
        Integer employeeNumber = EmployeesJooqDao.getLastEmployeeNumber();
        System.out.println("The following employee will be deleted:");
        System.out.println(EmployeesJooqDao.selectEmployeeByEmployeeNumber(employeeNumber));
        int numberOfDeletedRows = EmployeesJooqDao.deleteEmployee(employeeNumber);

        boolean isUserInDatabase = EmployeesJooqDao.isEmployeeInDatabase(employeeNumber);

        Assert.assertEquals(numberOfDeletedRows, 1, "Unexpected number of rows were deleted.");
        Assert.assertEquals(isUserInDatabase, false,
                "The employee with employee number " + employeeNumber + " is still in database.");
    }

}