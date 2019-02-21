package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			int id = 1;
			s.beginTransaction();
			
			Course course = s.get(Course.class, id);
			s.delete(course);
			
			
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
