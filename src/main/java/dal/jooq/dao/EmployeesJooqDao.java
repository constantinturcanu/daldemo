package dal.jooq.dao;

import dal.jooq.entities.enums.EmployeesGender;
import dal.jooq.entities.tables.Employees;
import dal.jooq.entities.tables.records.EmployeesRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static dal.jooq.entities.tables.Employees.EMPLOYEES_;

public class EmployeesJooqDao {

    private static DSLContext dslContext;

    static {
        String mysqlUsername = "demo_user";
        String mysqlPassword = "parola";
        String mysqlUrl = "jdbc:mysql://192.168.200.55:3306/employees";

        try {
            Connection mysqlConnection = DriverManager.getConnection(mysqlUrl, mysqlUsername, mysqlPassword);
            dslContext = DSL.using(mysqlConnection, SQLDialect.MYSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static EmployeesRecord storeEmployee(Integer employeeNumber,
                                                LocalDate birthDate,
                                                String firstName,
                                                String lastName,
                                                EmployeesGender gender,
                                                LocalDate hireDate) {
        EmployeesRecord newEmployee = dslContext.newRecord(EMPLOYEES_);
        newEmployee.setEmpNo(employeeNumber);
        newEmployee.setBirthDate(birthDate);
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        newEmployee.setGender(gender);
        newEmployee.setHireDate(hireDate);
        newEmployee.store();

        return newEmployee;
    }

    public static List<Record> selectEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        Result<Record> employees = dslContext
                .select()
                .from(EMPLOYEES_)
                .where(EMPLOYEES_.FIRST_NAME.eq(firstName))
                .and(EMPLOYEES_.LAST_NAME.eq(lastName))
                .fetch();

        return employees;
    }

    public static EmployeesRecord selectEmployeeByEmployeeNumber(int employeeNumber) {
        return  (EmployeesRecord) dslContext
                .select()
                .from(EMPLOYEES_)
                .where(EMPLOYEES_.EMP_NO.eq(employeeNumber))
                .fetchAny();
    }

    public static int updateEmployeeLastNameWhereEmployeeNumber(Integer employeeNumber, String newLastName) {
        int numberOfUpdatedRows = dslContext
                .update(EMPLOYEES_)
                .set(EMPLOYEES_.LAST_NAME, newLastName)
                .where(EMPLOYEES_.EMP_NO.eq(employeeNumber))
                .execute();

        return numberOfUpdatedRows;
    }

    public static int deleteEmployee(int employeeNumber) {
        int numberOfDeletedRows = dslContext
                .delete(EMPLOYEES_)
                .where(EMPLOYEES_.EMP_NO.eq(employeeNumber))
                .execute();

        return numberOfDeletedRows;
    }

    public static Integer getLastEmployeeNumber() {
        return dslContext
                .select(DSL.max(EMPLOYEES_.EMP_NO))
                .from(EMPLOYEES_)
                .fetchAny()
                .value1();
    }

    public static Integer getNextAvailableEmployeeNumber() {
        return getLastEmployeeNumber() + 1;
    }

    public static boolean isEmployeeInDatabase(Integer employeeNumber) {
        return selectEmployeeByEmployeeNumber(employeeNumber) != null;
    }
}
