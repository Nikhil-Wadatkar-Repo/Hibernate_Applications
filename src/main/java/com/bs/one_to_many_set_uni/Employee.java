package com.bs.one_to_many_set_uni;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Employee {
	@Id
	@Column(name = "emp_id")
	@GenericGenerator(name = "gen1", strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private int id;
	private int age;
	private String firstName, lastName;
	@OneToMany(targetEntity = LicenseDetails.class, orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "UNID", referencedColumnName = "emp_id")
	private Set<LicenseDetails> license;

	public Employee() {
		super();
	}

	public Employee(int id, int age, String firstName, String lastName) {
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

	public Set<LicenseDetails> getLicense() {
		return license;
	}

	public void setLicense(Set<LicenseDetails> license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "\n" + id + " " + firstName + " " + lastName + " " + age;
	}

}
