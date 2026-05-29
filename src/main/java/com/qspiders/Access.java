package com.qspiders;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Access {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
//		Perform all CRUD Operations	= create,insert,update,delete
		
		//create
		Employee e1 = new Employee(1, "Priyanka" ,"Enviromental Science" , 35000, LocalDate.of(2024, 3, 1));
		Employee e2 = new Employee(2, "Anmol" ,"Computer" , 45000, LocalDate.of(2024, 6, 1));
		Employee e3 = new Employee(3, "Ekta" ,"Mathematics" , 25000, LocalDate.of(2024, 9, 14));
		Employee e4 = new Employee(4, "Priyanshi" ,"Hindi" , 35000, LocalDate.of(2024, 6, 14));
		Employee e5 = new Employee(5, "Ashish" ,"Social Science" , 55000, LocalDate.of(2025, 3, 14));
		Employee e6 = new Employee(6, "Mehak" ,"Science" , 65000, LocalDate.of(2024, 12, 14));
//		
		//insert
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);
		em.persist(e6);
		
		// Updates employee salary based on employeeId using JPQL bulk update
		Query query =em.createQuery("update Employee e set e.employee_salary=:employee_salary where employee_id=:id ");
		query.setParameter("employee_salary", 27000d);
		query.setParameter("id", 3);
//		query.setParameter("employee_salary", 55000);
//		query.setParameter("id", 1);
		int rowsUpdated = query.executeUpdate();
        System.out.println("Rows Updated: " + rowsUpdated);
//				
		System.out.println("================ Updated Employee Details ====================");
		Query query1 = em.createQuery("select e from Employee e");
		List <Employee> li =query1.getResultList();
		for(Employee e :li ) {
			System.out.println("Employee Id: " + e.getEmployee_id() + "\n" + "Employee Name: " + e.getEmployee_name() +"\n" +"Employee Department"+e.getEmployee_department() + "Employee Salary"+e.getEmployee_salary()+"\n" + "Employee Joining date: "+e.getEmployee_joining_date() + "\n");
		}
		
		//delete
		Query query2=em.createQuery("delete from Employee e where e.employee_id=:id ");
		query2.setParameter("id", 3);
		int delete = query2.executeUpdate();
		System.out.println("Rows deleted: " +delete);
		System.out.println("================ Updated Employee Details ====================");
		Query query3 = em.createQuery("select e from Employee e");
		List <Employee> li2 =query3.getResultList();
		
		for(Employee e :li2) {
			System.out.println("Employee Id: " + e.getEmployee_id() + "\n" + "Employee Name: " + e.getEmployee_name() +"\n" +"Employee Department"+e.getEmployee_department() +"\n"+ "Employee Salary: "+e.getEmployee_salary()+"\n" + "Employee Joining date: "+e.getEmployee_joining_date() + "\n");
		}

		
		
		
		
//		Display employees whose salary > 50000
		Query query4 = em.createQuery("select e from Employee e where e.employee_salary>50000 ");
		List <Employee> li3 =query4.getResultList();
		
		for(Employee e :li3 ) {
			System.out.println("Employee Id: " + e.getEmployee_id() + "\n" + "Employee Name: " + e.getEmployee_name()  + "\n" +"Employee Salary: "+e.getEmployee_salary() + "\n");
		}
		
		et.commit();
		em.close();
        emf.close();
		

	}

}
