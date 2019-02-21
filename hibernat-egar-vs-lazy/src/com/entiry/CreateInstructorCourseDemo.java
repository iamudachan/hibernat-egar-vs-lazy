package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorCourseDemo {

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
			Course course1 = new Course("one");
			Course course2 = new Course("two");

			instructor.add(course1);
			instructor.add(course2);
			s.save(course1);
			s.save(course2);
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
