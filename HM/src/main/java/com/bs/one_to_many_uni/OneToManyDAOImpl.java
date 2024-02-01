package com.bs.one_to_many_uni;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bs.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAOI {

	public void saveDataUsingExmployee() {
		Employee emp = new Employee(12, 98, "Ganesh", "Dadmal");
		Set<LicenseDetails> childs = new HashSet<LicenseDetails>();
		childs.add(new LicenseDetails(34, "Voter ID"));
		childs.add(new LicenseDetails(33, "Pan Card"));
		emp.setLicense(childs);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(emp);
			System.out.println("emp saved");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			HibernateUtil.shutdown();
		}

	}

	public void loadDataUsingExmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> parent=query.list();
		for(Employee emp:parent) {
			System.out.print(emp);
			for(LicenseDetails child:emp.getLicense())
				System.out.println(child);
		}
		
	}

	public void addNewDataToExistingEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee=(Employee) session.get(Employee.class, 2);
		LicenseDetails child=new LicenseDetails(18, "Company card");
		
//		get child and save it directly in session
		Set<LicenseDetails> childs=employee.getLicense();
		
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			childs.add(child);
			System.out.println("childs added to existing parent");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	public void deleteEmployeWithLicenses() {
		//get()
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee=(Employee) session.get(Employee.class, 1);
		//delete()
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(employee);
			System.out.println("childs added to existing parent");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

	public void deleteOneLicenseOfEmployee() {
		//get()
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee=(Employee) session.get(Employee.class, 1);
		//get all childs
		Set<LicenseDetails> childs=employee.getLicense();
		//load child object
		LicenseDetails license=(LicenseDetails) session.get(LicenseDetails.class, 44);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			//remove one child from collection property using remove()
			childs.remove(license);
			System.out.println("one child deleted from parent");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	public void deleteAllLicenseOfEmployee() {
		//get()
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee=(Employee) session.get(Employee.class, 1);
		//retrieve all cilds from parent 
		Set<LicenseDetails> license=employee.getLicense();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			//remove one child from collection property using remove()
			license.clear();
			System.out.println("All childs deleted from parent");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		//clear() on childs

	}

}
