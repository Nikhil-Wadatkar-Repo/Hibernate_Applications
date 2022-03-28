package com.bs;

public class ClientApp {

	public static void main(String[] args) {
		
		
		OneToManyListDAOI methods=new OneToManyDAOListUniImpl();
		
		
		methods.saveDataUsingExmployeeList();
//		methods.loadDataUsingExmployeeList();
//		methods.addNewDataToExistingEmployeeList();
//		methods.deleteEmployeListWithLicenses();
//		methods.deleteOneLicenseOfEmployeeList();
//		methods.deleteAllLicenseOfEmployeeList();
		
		
		
		
		
		HibernateUtil.shutdown();
	}

}
