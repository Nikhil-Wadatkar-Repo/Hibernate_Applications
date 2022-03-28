package com.bs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bs.one_to_many_set_uni.Employee;
//select query for 
//1. retrieving whole table using list(), iterate()
//2. retrieving specific columns of table return list of Object[]
//3. retrieving specific single column
//4. sub queries which returns list of Object
//5. non-select queries
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;

		// simple query
		query = session.createQuery("from Employee where id>? and age > :name");
		query.setInteger(0, 12);
		query.setInteger("name", 12);
		List<Employee> list = query.list();
		System.out.println(list);

//		Retrieve specific colunms
		query = session.createQuery("select id , age from Employee");
		List<Object[]> list2 = query.list();
		for (Object[] arr : list2) {
			for (Object obj : arr)
				System.out.println(arr.toString());
		}

//		Retrieve specific single colomns using list method
		query = session.createQuery("select firstName from Employee");
		List<String> list3 = query.list();
		for (String arr : list3) {
			System.out.println(arr.toString());
		}

//		Retrieve specific single column using iterate method
		query = session.createQuery("select age from Employee");
		Iterator iterator = query.iterate();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// sub queries
//		query = session
//				.createQuery("select firstName from Employee where age=(select firstName from Employee id=:empId)");
//		query.setInteger("empId", 14);
//		List<Employee> list4 = query.list();
//		System.out.println(list4.get(0));

//		non-select queries
		query = session.createQuery("delete from Employee where age = 14");
		List<Integer> reult = query.list();
		System.out.println(reult.get(0));
		HibernateUtil.shutdown();
	}
}
