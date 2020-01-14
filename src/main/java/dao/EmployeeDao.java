package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.Config;
import model.Employee;

public class EmployeeDao {
	private static SessionFactory sessionFactory;
	
	public EmployeeDao(){
		sessionFactory = Config.getSessionFactory();
	}
	
	public List<Employee> getAll(){
		Session session = sessionFactory.openSession();
		String query = "from Employee e";
		List<Employee> employees = 
				session.createQuery(query).list();
		session.close();
		return employees;
	}
	
	public Employee getOne(int employeeId){
		Session session = sessionFactory.openSession();
		String query = "from Employee e where e.employeeId = :empId";
		Query q = session.createQuery(query);
		q.setParameter("empId", employeeId);
		Employee emp = (Employee)q.getSingleResult();
		session.close();
		return emp;
//		Employee employee = 
//				(Employee)session.createQuery(query)
//								.setParameter("empId", employeeId)
//								.getSingleResult();
	}
	
	public void insertEmployee(Employee employee){
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			if(employee.getEmployeeId() == 0) 
				throw new Exception("Employee Id is 0");
			session.save(employee);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}
		session.close();
	}
	
	public void updateEmployee(Employee employee){
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		String query = "update Employee set firstName = :firstName, lastName = :lastName where employeeId = :id";
		Query q = session.createQuery(query);
		q.setParameter("firstName", employee.getFirstName());
		q.setParameter("lastName", employee.getLastName());
		q.setParameter("id", employee.getEmployeeId());
		q.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void deleteEmployee(Employee employee){
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void deleteById(int employeeId){
		
	}
}
