/*
 * This file is generated by jOOQ.
 */
package dal.jooq;


import dal.jooq.tables.CurrentDeptEmp;
import dal.jooq.tables.Departments;
import dal.jooq.tables.DeptEmp;
import dal.jooq.tables.DeptEmpLatestDate;
import dal.jooq.tables.DeptManager;
import dal.jooq.tables.Employees;
import dal.jooq.tables.Salaries;
import dal.jooq.tables.Titles;


/**
 * Convenience access to all tables in employees
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * VIEW
     */
    public static final CurrentDeptEmp CURRENT_DEPT_EMP = CurrentDeptEmp.CURRENT_DEPT_EMP;

    /**
     * The table <code>employees.departments</code>.
     */
    public static final Departments DEPARTMENTS = Departments.DEPARTMENTS;

    /**
     * The table <code>employees.dept_emp</code>.
     */
    public static final DeptEmp DEPT_EMP = DeptEmp.DEPT_EMP;

    /**
     * VIEW
     */
    public static final DeptEmpLatestDate DEPT_EMP_LATEST_DATE = DeptEmpLatestDate.DEPT_EMP_LATEST_DATE;

    /**
     * The table <code>employees.dept_manager</code>.
     */
    public static final DeptManager DEPT_MANAGER = DeptManager.DEPT_MANAGER;

    /**
     * The table <code>employees.employees</code>.
     */
    public static final Employees EMPLOYEES_ = Employees.EMPLOYEES_;

    /**
     * The table <code>employees.salaries</code>.
     */
    public static final Salaries SALARIES = Salaries.SALARIES;

    /**
     * The table <code>employees.titles</code>.
     */
    public static final Titles TITLES = Titles.TITLES;
}
