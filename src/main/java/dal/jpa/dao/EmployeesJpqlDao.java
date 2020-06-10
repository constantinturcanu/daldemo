package dal.jpa.dao;

import dal.jpa.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesJpqlDao {

    public static EntityManager entitymanager;

    static {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA_Demo" );
        entitymanager = emfactory.createEntityManager();
    }

    public static void insertEmployee() {

    }

    public static List<Employee> selectEmployeeByFirstName(String firstName) {
        Query query = entitymanager.createQuery("SELECT e FROM Employee e WHERE e.firstName='" + firstName + "'");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    public static List<Employee> selectEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        Query query = entitymanager.createQuery("SELECT e FROM Employee e WHERE e.firstName='" + firstName + "'" +
                " AND e.lastName='" + lastName + "'");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    public static void updateEmployee() {

    }

    public static void deleteEmployee() {

    }

}
