package dal.jpa.dao;

import dal.jpa.entities.Employee;
import dal.jpa.factories.DatabaseConnection;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// find more JPQL examples at https://en.wikibooks.org/wiki/Java_Persistence/JPQL
public class EmployeesJpqlDao {

    // There's no INSERT statement in JPQL.
    // The workaround is to use createNativeQuery()
    //  - note the use of EntityTransaction
    //    and actual table name and column names, instead of Entity class name and fields
    public static int insertEmployee(Date birthDate,
                                     String firstName,
                                     String lastName,
                                     String gender,
                                     Date hireDate) {
        int empNo = getNextAvailableEmployeeNumber();
        String query = "INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) " +
                "VALUES (?,?,?,?,?,?)";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        EntityTransaction entityTransaction = entitymanager.getTransaction();
        entityTransaction.begin();
        entitymanager.createNativeQuery(query)
                .setParameter(1, empNo)
                .setParameter(2, birthDate)
                .setParameter(3, firstName)
                .setParameter(4, lastName)
                .setParameter(5, gender)
                .setParameter(6, hireDate)
                .executeUpdate();
        entityTransaction.commit();
        entitymanager.close();
        return empNo;
    }

    public static Employee selectEmployeeWhereEmployeeNumber(int employeeNumber) {
        String query = "SELECT e FROM Employee e WHERE e.empNo=" + employeeNumber + "";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        Employee employee = entitymanager
                .createQuery(query, Employee.class)
                .getSingleResult();
        entitymanager.close();
        return employee;
    }

    public static List<Employee> selectEmployeeWhereFirstName(String firstName) {
        String query = "SELECT e FROM Employee e WHERE e.firstName='" + firstName + "'";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        List<Employee> employees = entitymanager
                .createQuery(query)
                .getResultList();
        entitymanager.close();
        return employees;
    }

    public static List<Employee> selectEmployeeWhereFirstNameAndLastName(String firstName, String lastName) {
        String query = "SELECT e FROM Employee e WHERE e.firstName='" + firstName + "' AND e.lastName='" + lastName + "'";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        List<Employee> employees = entitymanager.createQuery(query).getResultList();
        entitymanager.close();
        return employees;
    }

    public static List<Employee> selectEmployeeWhereFirstNameLike(String firstName) {
        String query = "SELECT e FROM Employee e WHERE e.firstName LIKE '%" + firstName + "%'";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        List<Employee> employees = entitymanager
                .createQuery(query)
                .getResultList();
        entitymanager.close();
        return employees;
    }

    // EntityTransaction is required
    // Query is build with named parameters
    public static int updateEmployeeLastNameWhereFirstNameAndLastName(String firstName,
                                                                       String lastName,
                                                                       String newLastName) {
        String query = "UPDATE Employee e" +
                " SET e.lastName=:newLastName" +
                " WHERE e.firstName=:firstName" +
                " AND e.lastName=:lastName";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        EntityTransaction entityTransaction = entitymanager.getTransaction();
        entityTransaction.begin();
        int updatedRowsCount = entitymanager.createQuery(query)
                .setParameter("newLastName", newLastName)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .executeUpdate();
        entityTransaction.commit();
        entitymanager.close();
        return updatedRowsCount;
    }

    public static int deleteEmployeeWhereFirstNameAndLastName(String firstName, String lastName ) {
        String query = "DELETE FROM Employee e" +
                " WHERE e.firstName='" + firstName + "' "+
                " AND e.lastName='" + lastName + "'";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        int deletedRowsCount = entitymanager.createQuery(query).executeUpdate();
        entitymanager.close();
        return deletedRowsCount;
    }

    public static int deleteEmployeeWhereEmployeeNumber(int employeeNumber) {
        String query = "DELETE FROM Employee e WHERE e.empNo=:employeeNumber";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        EntityTransaction entityTransaction = entitymanager.getTransaction();
        entityTransaction.begin();
        int deletedRowsCount = entitymanager.createQuery(query)
                .setParameter("employeeNumber", employeeNumber)
                .executeUpdate();
        entityTransaction.commit();
        entitymanager.close();
        return deletedRowsCount;
    }

    public static int getNextAvailableEmployeeNumber() {
        return getLastEmployeeNumber() + 1;
    }

    public static int getLastEmployeeNumber() {
        String query = "SELECT MAX(e.empNo) FROM Employee e";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        EntityTransaction entityTransaction = entitymanager.getTransaction();
        entityTransaction.begin();
        int lastEmployeeNumberId = entitymanager.createQuery(query, Integer.class)
                .getSingleResult();
        entityTransaction.commit();
        entitymanager.close();
        return lastEmployeeNumberId;
    }

    public static boolean isEmployeeInDatabaseByEmployeeNumber(int employeeNumber) {
        String query = "SELECT COUNT(e) FROM Employee e WHERE e.empNo=:employeeNumber";
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        long foundEmployeesCount = entitymanager.createQuery(query, Long.class)
                .setParameter("employeeNumber", employeeNumber)
                .getSingleResult();
        entitymanager.close();
        return foundEmployeesCount > 0;
    }

}