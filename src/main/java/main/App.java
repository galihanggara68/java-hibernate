package main;

import java.util.List;

import model.Department;
import model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.EmployeeDao;

public class App {
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDao();
		
		Employee emp = empDao.getOne(100); // Steven King
		Department dept = emp.getDepartment(); // Department si Steven
		
		List<Employee> employees = dept.getEmployees();
		for(Employee e : employees){
			System.out.println(e.getFirstName());
		}
	}

}
