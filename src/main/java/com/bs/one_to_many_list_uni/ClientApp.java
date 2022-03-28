package com.bs.one_to_many_list_uni;

import com.bs.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
		
		
		OneToManyListDAOI methods=new OneToManyDAOListUniImpl();
		
		
//		methods.saveDataUsingExmployeeList();
//		methods.loadDataUsingExmployeeList();
//		methods.addNewDataToExistingEmployeeList();
//		methods.deleteEmployeListWithLicenses();
//		methods.deleteOneLicenseOfEmployeeList();
		methods.deleteAllLicenseOfEmployeeList();
		
		
		
		
		
		HibernateUtil.shutdown();
	}

}
