package dal.jpa.entities;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name="EMPLOYEES_EMPNO_GENERATOR", sequenceName="JPA_DEMO_SEQUENCE")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEES_EMPNO_GENERATOR")
//	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 600000, allocationSize = 10000)
//	@GeneratedValue(generator = "mySeqGen")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="emp_no")
	private int empNo;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	@Column(name="first_name")
	private String firstName;

	@Column(columnDefinition="ENUM('M','F')")
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	private Date hireDate;

	@Column(name="last_name")
	private String lastName;

	public Employee() {
	}

	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format(
				"emp_no     birth_date     first_name          last_name        gender    hire_date\n" +
				"%-11s%-15s%-20s%-17s%-10s%s",
				empNo,
				birthDate,
				firstName,
				lastName,
				gender,
				hireDate);
	}
}