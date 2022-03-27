package com.bs.one_to_many;

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
		Employee emp = new Employee(10, 25, "ankur", "Wadatkar");
		Set<LicenseDetails> childs = new HashSet<LicenseDetails>();
		childs.add(new LicenseDetails(44, "Aahar card"));
		childs.add(new LicenseDetails(55, "Voter ID"));
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

	}

	public void deleteEmployeWithLicenses() {
		// TODO Auto-generated method stub

	}

	public void deleteOneLicenseOfEmployee() {
		// TODO Auto-generated method stub

	}

	public void deleteAllLicenseOfEmployee() {
		// TODO Auto-generated method stub

	}

}
