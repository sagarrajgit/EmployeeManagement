package com.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.employee.model.Employee;
import com.java.dbConnection.ConnectionFactory;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void addEmployee(Employee employee) {
		// add in DB
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			String query="insert into employee values('"+employee.getId()+"', '"+employee.getFname()+"', '"+employee.getLname()+"', '"+employee.getAge()+"', '"+employee.getDob()+"', '"+employee.getSalary()+"', '"+employee.getDept()+"')";
			statement.executeUpdate(query);
			System.out.println("Empoyee Added");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void displayEmployee() {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from employee");
			
			while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void filterEmployee(String record, String value) {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from employee where "+record+"='"+value+"';");
			
			while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void searchEmployee(String id) {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from employee where id='"+id+"';");
			
			while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(String id, String record, String value) {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			String query="UPDATE `assignment`.`employee` SET "+record+" = '"+value+"' WHERE (`id` = '"+id+"');";
			statement.executeUpdate(query);
			System.out.println("Data Updated.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(String value) {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			String query="delete from employee where id='"+value+"'";
			statement.executeUpdate(query);
			System.out.println("Data Deleted.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void avgDeptSalary(String dept) {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select department, avg(salary) from assignment.employee group by department having department='"+dept+"';");
			
			while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getInt(2));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void avgSalary() {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select avg(salary) from employee;");
			
			while(rs.next()) {
					System.out.println(rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
