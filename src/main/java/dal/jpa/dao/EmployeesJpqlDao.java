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

    public static List<Employee> readEmployeeByFirstName(String firstName) {
        Query query = entitymanager.createQuery("SELECT e FROM Employee e WHERE e.firstName='" + firstName + "'");
        List<Employee> employees = query.getResultList();

        return employees;
    }

}
