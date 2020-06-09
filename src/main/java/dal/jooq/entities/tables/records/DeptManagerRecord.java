/*
 * This file is generated by jOOQ.
 */
package dal.jooq.entities.tables.records;


import dal.jooq.entities.tables.DeptManager;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeptManagerRecord extends UpdatableRecordImpl<DeptManagerRecord> implements Record4<Integer, String, LocalDate, LocalDate> {

    private static final long serialVersionUID = 517607902;

    /**
     * Setter for <code>employees.dept_manager.emp_no</code>.
     */
    public void setEmpNo(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>employees.dept_manager.emp_no</code>.
     */
    public Integer getEmpNo() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>employees.dept_manager.dept_no</code>.
     */
    public void setDeptNo(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>employees.dept_manager.dept_no</code>.
     */
    public String getDeptNo() {
        return (String) get(1);
    }

    /**
     * Setter for <code>employees.dept_manager.from_date</code>.
     */
    public void setFromDate(LocalDate value) {
        set(2, value);
    }

    /**
     * Getter for <code>employees.dept_manager.from_date</code>.
     */
    public LocalDate getFromDate() {
        return (LocalDate) get(2);
    }

    /**
     * Setter for <code>employees.dept_manager.to_date</code>.
     */
    public void setToDate(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>employees.dept_manager.to_date</code>.
     */
    public LocalDate getToDate() {
        return (LocalDate) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Integer, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, LocalDate, LocalDate> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, LocalDate, LocalDate> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return DeptManager.DEPT_MANAGER.EMP_NO;
    }

    @Override
    public Field<String> field2() {
        return DeptManager.DEPT_MANAGER.DEPT_NO;
    }

    @Override
    public Field<LocalDate> field3() {
        return DeptManager.DEPT_MANAGER.FROM_DATE;
    }

    @Override
    public Field<LocalDate> field4() {
        return DeptManager.DEPT_MANAGER.TO_DATE;
    }

    @Override
    public Integer component1() {
        return getEmpNo();
    }

    @Override
    public String component2() {
        return getDeptNo();
    }

    @Override
    public LocalDate component3() {
        return getFromDate();
    }

    @Override
    public LocalDate component4() {
        return getToDate();
    }

    @Override
    public Integer value1() {
        return getEmpNo();
    }

    @Override
    public String value2() {
        return getDeptNo();
    }

    @Override
    public LocalDate value3() {
        return getFromDate();
    }

    @Override
    public LocalDate value4() {
        return getToDate();
    }

    @Override
    public DeptManagerRecord value1(Integer value) {
        setEmpNo(value);
        return this;
    }

    @Override
    public DeptManagerRecord value2(String value) {
        setDeptNo(value);
        return this;
    }

    @Override
    public DeptManagerRecord value3(LocalDate value) {
        setFromDate(value);
        return this;
    }

    @Override
    public DeptManagerRecord value4(LocalDate value) {
        setToDate(value);
        return this;
    }

    @Override
    public DeptManagerRecord values(Integer value1, String value2, LocalDate value3, LocalDate value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DeptManagerRecord
     */
    public DeptManagerRecord() {
        super(DeptManager.DEPT_MANAGER);
    }

    /**
     * Create a detached, initialised DeptManagerRecord
     */
    public DeptManagerRecord(Integer empNo, String deptNo, LocalDate fromDate, LocalDate toDate) {
        super(DeptManager.DEPT_MANAGER);

        set(0, empNo);
        set(1, deptNo);
        set(2, fromDate);
        set(3, toDate);
    }
}