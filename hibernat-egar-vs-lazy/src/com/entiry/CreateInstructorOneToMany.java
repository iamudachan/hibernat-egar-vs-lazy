package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorOneToMany {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			
			Instructor i = new Instructor("hello","typo","hello@aaa.com");
			InstructorDetails id = new InstructorDetails("hello ", "watchinasdfasdfg");
			i.setInstructorDetails(id);
			s.beginTransaction();
			s.save(i);
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}

	}

}
