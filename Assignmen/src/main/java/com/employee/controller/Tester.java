package com.employee.controller;

import java.util.Scanner;

import com.employee.dao.EmployeeServiceImpl;
import com.employee.model.Employee;

public class Tester {
	public static void main(String[] args) {
		
		EmployeeServiceImpl impl=new EmployeeServiceImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("What you want to perform?");
		System.out.println("Press 1 to Add Employee");
		System.out.println("Press 2 to Show All Employees");
		System.out.println("Press 3 to Filter An Employee");
		System.out.println("Press 4 to Search An Employee using Id");
		System.out.println("Press 5 to Update An Employee");
		System.out.println("Press 6 to Delete An Employee");
		System.out.println("Press 7 to get Average Salary of Employees in Specific Department");
		System.out.println("Press 8 to get Average Salary of all Employees");
		int choice=scanner.nextInt();
		
		// add
		if(choice==1) {
			System.out.println("Enter Employee Details(Id, fname, lname, Age, DOB(DD/MM/YYYY), Salary, Department)");
			Employee employee=new Employee();
			employee.setId(scanner.nextInt());
			employee.setFname(scanner.next());
			employee.setLname(scanner.next());
			employee.setAge(scanner.next());
			employee.setDob(scanner.next());
			employee.setSalary(scanner.nextInt());
			employee.setDept(scanner.next());
			impl.addEmployee(employee);
		}
		// show all
		else if(choice==2){
			impl.displayEmployee();
		}
		// filter
		else if(choice==3) {
			System.out.println("Press 1 to Filter using Id");
			System.out.println("Press 2 to Filter using First name");
			System.out.println("Press 3 to Filter using Last name");
			System.out.println("Press 4 to Filter using Age");
			System.out.println("Press 5 to Filter using DoB");
			System.out.println("Press 6 to Filter using Salary");
			System.out.println("Press 7 to Filter using Department");
			
			int option=scanner.nextInt();
			if(option==1) {
				System.out.println("Enter Employee Id: ");
				String value=scanner.next();
				String id="id";
				impl.filterEmployee(id, value);
			}
			else if(option==2) {
				System.out.println("Enter Employee fname: ");
				String value=scanner.next();
				String fname="fname";
				impl.filterEmployee(fname, value);
			}
			else if(option==3) {
				System.out.println("Enter Employee lname: ");
				String value=scanner.next();
				impl.filterEmployee("lname", value);
			}
			else if(option==4) {
				System.out.println("Enter Employee Age: ");
				String value=scanner.next();
				impl.filterEmployee("age", value);
			}
			else if(option==5) {
				System.out.println("Enter Employee DoB(DD/MM/YYYY): ");
				String value=scanner.next();
				impl.filterEmployee("DOB", value);
			}
			else if(option==6) {
				System.out.println("Enter Employee Salary: ");
				String value=scanner.next();
				impl.filterEmployee("salary", value);
			}
			else if(option==7) {
				System.out.println("Enter Employee Department: ");
				String value=scanner.next();
				impl.filterEmployee("department", value);
			}
		}
		// search
		else if(choice==4) {
			System.out.println("Enter Id to search Employee: ");
			String id=scanner.next();
			impl.searchEmployee(id);
		}
		// update
		else if(choice==5) {
			System.out.println("Enter Employee Id: ");
			String id=scanner.next();
			System.out.println("Press 1 to Update First name");
			System.out.println("Press 2 to Update Last name");
			System.out.println("Press 3 to Update Age");
			System.out.println("Press 4 to Update DoB");
			System.out.println("Press 5 to Update Salary");
			System.out.println("Press 6 to Update Department");
			
			int option=scanner.nextInt();
			
			if(option==1) {
				System.out.println("Enter Update Value: ");
				String value=scanner.next();
				impl.updateEmployee(id, "fname",value);
				impl.searchEmployee(id);
			}
			else if(option==2) {
				System.out.println("Enter Update Value: ");
				String value=scanner.next();
				impl.updateEmployee(id, "lname", value);
				impl.searchEmployee(id);
			}
			else if(option==3) {
				System.out.println("Enter Update Value: ");
				String value=scanner.next();
				impl.updateEmployee(id, "age", value);
				impl.searchEmployee(id);
			}
			else if(option==4) {
				System.out.println("Enter Update Value(DD/MM/YYYY): ");
				String value=scanner.next();
				impl.updateEmployee(id, "DOB", value);
				impl.searchEmployee(id);
			}
			else if(option==5) {
				System.out.println("Enter Update Value: ");
				String value=scanner.next();
				impl.updateEmployee(id, "salary", value);
				impl.searchEmployee(id);
			}
			else if(option==6) {
				System.out.println("Enter Update Value: ");
				String value=scanner.next();
				impl.updateEmployee(id, "department", value);
				impl.searchEmployee(id);
			}
		}
		// delete
		else if(choice==6) {
			impl.displayEmployee();
			System.out.println("Select Employee Id to delete: ");
			String value=scanner.next();
			impl.deleteEmployee(value);
			impl.displayEmployee();
		}
		else if(choice==7) {
			System.out.println("Enter Department name: ");
			String value=scanner.next();
			impl.avgDeptSalary(value);
		}
		else if(choice==8) {
			impl.avgSalary();
		}
		else {
			System.out.println("Invalid Choice");
		}
	}
}
