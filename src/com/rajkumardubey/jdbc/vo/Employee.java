package com.rajkumardubey.jdbc.vo;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * <h1>serialVersionUID</h1>
	 */
	private static final long serialVersionUID = 1138942673269628263L;

	private int id;
	private String name;
	private String department;
	private double salary;

	public Employee() {
		this.id = 0;
		this.name = "sample name";
		this.department = "sample department";
		this.salary = 10000.50;
	}

	/**
	 * @param id
	 * @param name
	 * @param department
	 * @param salary
	 */
	public Employee(final int id, final String name, final String department, final double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}

}
