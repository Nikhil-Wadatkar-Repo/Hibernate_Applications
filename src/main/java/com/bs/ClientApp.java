package com.bs;

import org.hibernate.Session;

public class ClientApp {

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
