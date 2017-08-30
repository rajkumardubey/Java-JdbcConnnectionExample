package com.rajkumardubey.jdbc.dao;

/*
 * <h1>EmployeeDAO</h1>
 * 
 * This is a DAO class. DAO means Data Access Object.
 * This class provide some static function that is used to Add, Update, Delete or Select an attribute in "employee" table
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.rajkumardubey.jdbc.util.DatabaseUtil;
import com.rajkumardubey.jdbc.vo.Employee;

public class EmployeeDAO {

	public static boolean addEmployee(final Employee inputEmployee) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		boolean sucess = false;
		boolean isExist = false;

		try {

			/*
			 * to check whether the EMP_NO of the Employee being added is
			 * already exist in the table or not if not then add the employee
			 * detail in the table
			 */
			final Collection<Employee> col = EmployeeDAO.getAllEmployee();
			final Iterator<Employee> itr = col.iterator();

			Employee employee;
			while (itr.hasNext()) {
				employee = itr.next();
				if (inputEmployee.getId() == employee.getId()) {
					isExist = true;
					break;
				}
			}

			/* If the employee does not exist in database then save */
			if (!isExist) {
				/* to load the driver & establish the connection */
				conn = DatabaseUtil.getDatabaseConnection();

				// to generate pre-compiled Query, Here "employee" is table name
				String query = "insert into employee values(?, ?, ?, ?)";

				// to generate the prepared statement
				pstmt = conn.prepareStatement(query);

				// to insert the unknown values in pre-complied Query
				pstmt.setInt(1, inputEmployee.getId());
				pstmt.setString(2, inputEmployee.getName());
				pstmt.setString(3, inputEmployee.getDepartment());
				pstmt.setDouble(4, inputEmployee.getSalary());

				// to execute the query
				count = pstmt.executeUpdate();
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		} finally {
			// Releasing the resourses
			try {
				pstmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.getStackTrace();
			}
			if (count != 0)
				sucess = true;
		}

		return sucess;
	}

	public static Collection<Employee> getAllEmployee() {
		Collection<Employee> coll = new ArrayList<Employee>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Employee emp = null;

		try // try block of getAllEmployee Method
		{
			// to load the driver & establish the connection
			conn = DatabaseUtil.getDatabaseConnection();

			// to generate pre-compiled Query
			final String query = "select * from employee";

			// to generate the statement
			stmt = conn.createStatement();

			// to execute the query
			rs = stmt.executeQuery(query);

			// to convert the ResultSet into Collection of Employee object
			while (rs.next()) {
				int v1 = rs.getInt(1);
				String v2 = rs.getString(2);
				String v3 = rs.getString(3);
				double v4 = rs.getDouble(4);
				emp = new Employee(v1, v2, v3, v4);
				coll.add(emp);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		} finally {
			// Releasing the resourses
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.getStackTrace();
			}
		}

		return coll;
	}

	public static Employee getEmployeeById(int eId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee emp = null;

		try // try block of getEmployeeById Method
		{
			// to load the driver & establish the connection
			conn = DatabaseUtil.getDatabaseConnection();

			// to generate pre-compiled Query
			String query = "select * from employee where empno = ?";

			// to generate the statement
			pstmt = conn.prepareStatement(query);

			// to insert the unknown values in pre-complied Query
			pstmt.setInt(1, eId);

			// to execute the query
			rs = pstmt.executeQuery();

			// to convert the ResultSet into Employee object
			if (rs.next()) {
				int v1 = rs.getInt(1);
				String v2 = rs.getString(2);
				String v3 = rs.getString(3);
				double v4 = rs.getDouble(4);
				emp = new Employee(v1, v2, v3, v4);
			}
		}

		catch (Exception ex) // catch block of getEmployeeById Method
		{
			ex.getStackTrace();
		}

		finally // finally block of getEmployeeById Method
		{
			// Releasing the resourses
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.getStackTrace();
			}
		}

		return emp;
	}

	public static boolean deleteEmployee(int eId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		boolean sucess = false;

		try // try block of getEmployeeById Method
		{
			// to load the driver & establish the connection
			conn = DatabaseUtil.getDatabaseConnection();

			// to generate pre-compiled Query
			String query = "delete from employee where empno = ?";

			// to generate the statement
			pstmt = conn.prepareStatement(query);

			// to insert the unknown values in pre-complied Query
			pstmt.setInt(1, eId);

			// to execute the query
			count = pstmt.executeUpdate();
		}

		catch (Exception ex) // catch block of getEmployeeById Method
		{
			ex.getStackTrace();
		}

		finally // finally block of getEmployeeById Method
		{
			// Releasing the resourses
			try {
				pstmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.getStackTrace();
			}
			if (count != 0)
				sucess = true;
		}
		return sucess;
	}

}
