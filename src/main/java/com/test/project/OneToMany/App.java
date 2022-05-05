package com.test.project.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.perscholas.model.Schools;
import com.perscholas.model.Students;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Schools school1 = new Schools();
		school1.setSchoolName("Brockton High School");

		Schools school2 = new Schools();
		school2.setSchoolName("Boston Latin");

		Students student1 = new Students();
		student1.setStudentName("Jay");
		student1.setCourseLoad(4);
		student1.setSchools(school2);

		Students student2 = new Students();
		student2.setStudentName("Nicole");
		student2.setCourseLoad(5);
		student2.setSchools(school2);

		Students student3 = new Students();
		student3.setStudentName("Glen");
		student3.setCourseLoad(2);
		student3.setSchools(school1);

		Students student4 = new Students();
		student4.setStudentName("Yakub");
		student4.setCourseLoad(7);
		student4.setSchools(school1);

		Students student5 = new Students();
		student5.setStudentName("Aaron");
		student5.setCourseLoad(7);
		student5.setSchools(school2);

		session.save(school1);
		session.save(school2);
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		session.save(student5);
		t.commit();

	}
}
