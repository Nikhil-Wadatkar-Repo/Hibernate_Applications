package com.bs.one_to_many_list_uni;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Employee_List")
public class EmployeeList {
	@Id
	@Column(name = "emp_id")
	@GenericGenerator(name = "gen1", strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private int id;
	private int age;
	private String firstName, lastName;
	
	@OneToMany(targetEntity = LicenseDetails_List.class, orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "UNID", referencedColumnName = "emp_id")
	@OrderColumn(name = "listIndexCol")
	private List<LicenseDetails_List> license;

	public List<LicenseDetails_List> getLicense() {
		return license;
	}

	public void setLicense(List<LicenseDetails_List> license) {
		this.license = license;
	}

	public EmployeeList() {
		super();
	}

	public EmployeeList(int id, int age, String firstName, String lastName) {
		super();
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	@Override
	public String toString() {
		return "\n" + id + " " + firstName + " " + lastName + " " + age;
	}

}
