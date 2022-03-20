package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hiernate.demo.entity.Course;
import com.luv2code.hiernate.demo.entity.Instructor;
import com.luv2code.hiernate.demo.entity.InstructorDetail;
import com.luv2code.hiernate.demo.entity.Student;

public class CreateInstructorDetail {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			//get instructor detail object
			Instructor instructor = new Instructor("susan","public","susan@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com","video game");
			instructor.setInstructorDetail(instructorDetail);
			session.save(instructor);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
			session.close();
		}
	}

}
