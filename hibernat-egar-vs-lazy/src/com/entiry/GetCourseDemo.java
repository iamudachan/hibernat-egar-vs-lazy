package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			int id = 1;
			s.beginTransaction();
			Instructor instructor = s.get(Instructor.class, id);
			System.out.println("instru ===" +instructor);
			System.out.println("instru ===" +instructor.getCourse());
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
