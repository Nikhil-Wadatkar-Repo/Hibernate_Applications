package com.bs.one_to_many;

import org.hibernate.Session;

import com.bs.HibernateUtil;

public class OneToManyDemo {

	public static void main(String[] args) {
		
		
		OneToManyDAOI methods=new OneToManyDAOImpl();
		
//		methods.saveDataUsingExmployee();
//		methods.loadDataUsingExmployee();
//		methods.addNewDataToExistingEmployee();
//		methods.deleteEmployeWithLicenses();
//		methods.deleteOneLicenseOfEmployee();
//		methods.deleteAllLicenseOfEmployee();
		
		
		
		
		
		HibernateUtil.shutdown();
	}

}
