package main;

import java.util.List;

import model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.EmployeeDao;

public class App {
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDao();
		
		Employee emp = empDao.getOne(989);
		emp.setFirstName("asasasaasa");
		empDao.updateEmployee(emp);
		
		Employee display = empDao.getOne(989);
		System.out.println(display.getFirstName());
	}

}
