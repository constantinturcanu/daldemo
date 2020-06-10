package dal.jpa.dao;

import dal.jpa.entities.Employee;
import dal.jpa.factories.DatabaseConnection;

import javax.persistence.EntityManager;
import java.util.Date;

public class EmployeesJpaDao {

    public static int persistEmployee(Date birthDate,
                                String firstName,
                                String lastName,
                                String gender,
                                Date hireDate) {

        int employeeNumber = EmployeesJpqlDao.getNextAvailableEmployeeNumber();
        Employee employee = new Employee();
        employee.setEmpNo(employeeNumber);
        employee.setBirthDate(birthDate);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setGender(gender);
        employee.setHireDate(hireDate);

        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        entitymanager.getTransaction().begin();
        entitymanager.persist(employee);
        entitymanager.getTransaction().commit();
        entitymanager.close();

        return employeeNumber;
    }

    public static Employee findEmployee(int employeeNumber) {
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        Employee employee = entitymanager.find(Employee.class, employeeNumber);
        entitymanager.close();

        return employee;
    }

    public static void updateEmployee(int employeeNumber, Employee updatedEmployee) {
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        Employee employeeToUpdate = entitymanager.find(Employee.class, employeeNumber);

        entitymanager.getTransaction().begin();
        employeeToUpdate.setBirthDate(updatedEmployee.getBirthDate());
        employeeToUpdate.setFirstName(updatedEmployee.getFirstName());
        employeeToUpdate.setLastName(updatedEmployee.getLastName());
        employeeToUpdate.setGender(updatedEmployee.getGender());
        employeeToUpdate.setHireDate(updatedEmployee.getHireDate());
        entitymanager.getTransaction().commit();
        entitymanager.close();
    }

    public static void removeEmployee(int employeeNumber) {
        EntityManager entitymanager = DatabaseConnection.getInstance().createEntityManager();
        Employee employeeToDelete = entitymanager.find(Employee.class, employeeNumber);

        entitymanager.getTransaction().begin();
        entitymanager.remove(employeeToDelete);
        entitymanager.getTransaction().commit();
        entitymanager.close();
    }

    public static boolean isEmployeeInDatabase(int employeeNumber) {
        return findEmployee(employeeNumber) != null;
    }
}
