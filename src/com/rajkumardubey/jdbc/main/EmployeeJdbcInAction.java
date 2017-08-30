package com.rajkumardubey.jdbc.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import com.rajkumardubey.jdbc.dao.EmployeeDAO;
import com.rajkumardubey.jdbc.vo.Employee;

public class EmployeeJdbcInAction {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("Press 0 to exit!!!!");
				System.out.println("Press 1 to Insert A Employee detail!!!");
				System.out.println("Press 2 to Delete A Employee detail!!!");
				System.out.println("Press 3 to view A particular Employee detail!!!");
				System.out.println("Press 4 to view Aall the Employee detail!!!");
				System.out.println("Enter Your Choice :-");
				int ch = Integer.parseInt(br.readLine());

				switch (ch) {
				case 0:
					System.out.println("Thank You!!!!!!!!!!!!!!!!!!!");
					System.exit(1);
					break;

				case 1:
					System.out.print("\nEnter The Employee No. of the New Employee : ");
					int eid0 = Integer.parseInt(br.readLine());

					System.out.print("\nEnter The Employee Name of the New Employee : ");
					String ename = br.readLine();

					System.out.print("\nEnter The Department of the New Employee : ");
					String dept = br.readLine();

					System.out.print("\nEnter The Salary of the New Employee : ");
					double sal = Double.parseDouble(br.readLine());

					Employee emp = new Employee(eid0, ename, dept, sal);

					if (EmployeeDAO.addEmployee(emp))
						System.out.println("One Record Added!!!!");
					else
						System.out.println("No Record Added!!!!");
					break;

				case 2:
					System.out.print("\nEnter The Employee No. of the Employee : ");
					int eid1 = Integer.parseInt(br.readLine());

					if (EmployeeDAO.deleteEmployee(eid1))
						System.out.println("Record deleted!!!!");
					else
						System.out.println("No Record deleted!!!!");
					break;

				case 3:
					System.out.print("\nEnter The Employee No. of the Employee : ");
					int eid2 = Integer.parseInt(br.readLine());

					Employee emp2 = EmployeeDAO.getEmployeeById(eid2);
					System.out.println(emp2);
					break;

				case 4:
					Collection<Employee> col = new ArrayList<Employee>();
					col = EmployeeDAO.getAllEmployee();
					System.out.println("Emp No.\tEmployee Name\tDepartment\tSalary");
					for (Employee e : col)
						System.out.println(e);
					break;

				default:
					System.out.println("Wrong Choice!!!!");
				}
			}
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

}
