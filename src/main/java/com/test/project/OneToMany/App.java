package com.test.project.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.perscholas.model.Departments;
import com.perscholas.model.Teachers;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Teachers t1 = new Teachers();
		t1.setTeachername("Haseeb");
		t1.setSalary("100");

		Teachers t2 = new Teachers();
		t2.setTeachername("Jenny Finch");
		t2.setSalary("10000");

		Teachers t3 = new Teachers();
		t3.setTeachername("James");
		t3.setSalary("25000");

		Teachers t4 = new Teachers();
		t4.setTeachername("SID ROSE");
		t4.setSalary("3000");

		Teachers t5 = new Teachers();
		t5.setSalary("200");
		t5.setTeachername("Ali");

		// Add Teachers entity object to the list
		List<Teachers> teachlist = new ArrayList();
		teachlist.add(t1);
		teachlist.add(t2);
		teachlist.add(t3);
		teachlist.add(t4);
		teachlist.add(t5);
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);

		// Create Department
		Departments departments = new Departments();
		departments.setDname("Development");
		departments.setTeacherList(teachlist);

		// Store Department
		session.save(departments);
		t.commit();
	}
}
