package com.bs.one_to_many_list_uni;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bs.HibernateUtil;

public class OneToManyDAOListUniImpl implements OneToManyListDAOI {

	public void saveDataUsingExmployeeList() {
		EmployeeList emp = new EmployeeList(12, 98, "Ganesh", "Dadmal");
		ArrayList<LicenseDetails_List> childs = new ArrayList<LicenseDetails_List>();
		childs.add(new LicenseDetails_List(34, "Voter ID"));
		childs.add(new LicenseDetails_List(33, "Pan Card"));
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

	public void loadDataUsingExmployeeList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from EmployeeList");
		List<EmployeeList> parent=query.list();
		for(EmployeeList emp:parent) {
			System.out.print(emp);
			for(LicenseDetails_List child:emp.getLicense())
				System.out.println(child);
		}
		
	}

	public void addNewDataToExistingEmployeeList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		EmployeeList employee=(EmployeeList) session.get(EmployeeList.class, 1);
		LicenseDetails_List child=new LicenseDetails_List(86, "Voter ID");
		
//		get child and save it directly in session
		List<LicenseDetails_List> childs=employee.getLicense();
		
		
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

	public void deleteEmployeListWithLicenses() {
		//get()
		Session session = HibernateUtil.getSessionFactory().openSession();
		EmployeeList employee=(EmployeeList) session.get(EmployeeList.class, 1);
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

	public void deleteOneLicenseOfEmployeeList() {
		//get()
		Session session = HibernateUtil.getSessionFactory().openSession();
		EmployeeList employee=(EmployeeList) session.get(EmployeeList.class, 2);
		//get all childs
		List<LicenseDetails_List> childs=employee.getLicense();
		//load child object
		LicenseDetails_List license=(LicenseDetails_List) session.get(LicenseDetails_List.class, 18);
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

	public void deleteAllLicenseOfEmployeeList() {
		//get()
		Session session = HibernateUtil.getSessionFactory().openSession();
		EmployeeList employee=(EmployeeList) session.get(EmployeeList.class, 2);
		//retrieve all cilds from parent 
		List<LicenseDetails_List> license=employee.getLicense();
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
