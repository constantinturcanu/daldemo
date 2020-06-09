/*
 * This file is generated by jOOQ.
 */
package dal.jooq.tables;


import dal.jooq.Keys;
import dal.jooq.enums.EmployeesGender;
import dal.jooq.tables.records.EmployeesRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Employees extends TableImpl<EmployeesRecord> {

    private static final long serialVersionUID = -367784423;

    /**
     * The reference instance of <code>employees.employees</code>
     */
    public static final Employees EMPLOYEES_ = new Employees();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EmployeesRecord> getRecordType() {
        return EmployeesRecord.class;
    }

    /**
     * The column <code>employees.employees.emp_no</code>.
     */
    public final TableField<EmployeesRecord, Integer> EMP_NO = createField(DSL.name("emp_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>employees.employees.birth_date</code>.
     */
    public final TableField<EmployeesRecord, LocalDate> BIRTH_DATE = createField(DSL.name("birth_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>employees.employees.first_name</code>.
     */
    public final TableField<EmployeesRecord, String> FIRST_NAME = createField(DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(14).nullable(false), this, "");

    /**
     * The column <code>employees.employees.last_name</code>.
     */
    public final TableField<EmployeesRecord, String> LAST_NAME = createField(DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * The column <code>employees.employees.gender</code>.
     */
    public final TableField<EmployeesRecord, EmployeesGender> GENDER = createField(DSL.name("gender"), org.jooq.impl.SQLDataType.VARCHAR(1).nullable(false).asEnumDataType(EmployeesGender.class), this, "");

    /**
     * The column <code>employees.employees.hire_date</code>.
     */
    public final TableField<EmployeesRecord, LocalDate> HIRE_DATE = createField(DSL.name("hire_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * Create a <code>employees.employees</code> table reference
     */
    public Employees() {
        this(DSL.name("employees"), null);
    }

    /**
     * Create an aliased <code>employees.employees</code> table reference
     */
    public Employees(String alias) {
        this(DSL.name(alias), EMPLOYEES_);
    }

    /**
     * Create an aliased <code>employees.employees</code> table reference
     */
    public Employees(Name alias) {
        this(alias, EMPLOYEES_);
    }

    private Employees(Name alias, Table<EmployeesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Employees(Name alias, Table<EmployeesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Employees(Table<O> child, ForeignKey<O, EmployeesRecord> key) {
        super(child, key, EMPLOYEES_);
    }

    @Override
    public Schema getSchema() {
        return dal.jooq.Employees.EMPLOYEES;
    }

    @Override
    public UniqueKey<EmployeesRecord> getPrimaryKey() {
        return Keys.KEY_EMPLOYEES_PRIMARY;
    }

    @Override
    public List<UniqueKey<EmployeesRecord>> getKeys() {
        return Arrays.<UniqueKey<EmployeesRecord>>asList(Keys.KEY_EMPLOYEES_PRIMARY);
    }

    @Override
    public Employees as(String alias) {
        return new Employees(DSL.name(alias), this);
    }

    @Override
    public Employees as(Name alias) {
        return new Employees(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Employees rename(String name) {
        return new Employees(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Employees rename(Name name) {
        return new Employees(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, LocalDate, String, String, EmployeesGender, LocalDate> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
