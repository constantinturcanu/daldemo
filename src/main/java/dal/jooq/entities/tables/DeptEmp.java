/*
 * This file is generated by jOOQ.
 */
package dal.jooq.entities.tables;


import dal.jooq.entities.Employees;
import dal.jooq.entities.Indexes;
import dal.jooq.entities.Keys;
import dal.jooq.entities.tables.records.DeptEmpRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class DeptEmp extends TableImpl<DeptEmpRecord> {

    private static final long serialVersionUID = 495283636;

    /**
     * The reference instance of <code>employees.dept_emp</code>
     */
    public static final DeptEmp DEPT_EMP = new DeptEmp();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DeptEmpRecord> getRecordType() {
        return DeptEmpRecord.class;
    }

    /**
     * The column <code>employees.dept_emp.emp_no</code>.
     */
    public final TableField<DeptEmpRecord, Integer> EMP_NO = createField(DSL.name("emp_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>employees.dept_emp.dept_no</code>.
     */
    public final TableField<DeptEmpRecord, String> DEPT_NO = createField(DSL.name("dept_no"), org.jooq.impl.SQLDataType.CHAR(4).nullable(false), this, "");

    /**
     * The column <code>employees.dept_emp.from_date</code>.
     */
    public final TableField<DeptEmpRecord, LocalDate> FROM_DATE = createField(DSL.name("from_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>employees.dept_emp.to_date</code>.
     */
    public final TableField<DeptEmpRecord, LocalDate> TO_DATE = createField(DSL.name("to_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * Create a <code>employees.dept_emp</code> table reference
     */
    public DeptEmp() {
        this(DSL.name("dept_emp"), null);
    }

    /**
     * Create an aliased <code>employees.dept_emp</code> table reference
     */
    public DeptEmp(String alias) {
        this(DSL.name(alias), DEPT_EMP);
    }

    /**
     * Create an aliased <code>employees.dept_emp</code> table reference
     */
    public DeptEmp(Name alias) {
        this(alias, DEPT_EMP);
    }

    private DeptEmp(Name alias, Table<DeptEmpRecord> aliased) {
        this(alias, aliased, null);
    }

    private DeptEmp(Name alias, Table<DeptEmpRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> DeptEmp(Table<O> child, ForeignKey<O, DeptEmpRecord> key) {
        super(child, key, DEPT_EMP);
    }

    @Override
    public Schema getSchema() {
        return Employees.EMPLOYEES;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.DEPT_EMP_DEPT_NO);
    }

    @Override
    public UniqueKey<DeptEmpRecord> getPrimaryKey() {
        return Keys.KEY_DEPT_EMP_PRIMARY;
    }

    @Override
    public List<UniqueKey<DeptEmpRecord>> getKeys() {
        return Arrays.<UniqueKey<DeptEmpRecord>>asList(Keys.KEY_DEPT_EMP_PRIMARY);
    }

    @Override
    public List<ForeignKey<DeptEmpRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DeptEmpRecord, ?>>asList(Keys.DEPT_EMP_IBFK_1, Keys.DEPT_EMP_IBFK_2);
    }

    public dal.jooq.entities.tables.Employees employees() {
        return new dal.jooq.entities.tables.Employees(this, Keys.DEPT_EMP_IBFK_1);
    }

    public Departments departments() {
        return new Departments(this, Keys.DEPT_EMP_IBFK_2);
    }

    @Override
    public DeptEmp as(String alias) {
        return new DeptEmp(DSL.name(alias), this);
    }

    @Override
    public DeptEmp as(Name alias) {
        return new DeptEmp(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DeptEmp rename(String name) {
        return new DeptEmp(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DeptEmp rename(Name name) {
        return new DeptEmp(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, LocalDate, LocalDate> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}