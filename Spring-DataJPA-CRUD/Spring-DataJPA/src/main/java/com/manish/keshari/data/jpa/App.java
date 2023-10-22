package com.manish.keshari.data.jpa;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manish.keshari.data.jpa.config.PackConfiguration;
import com.manish.keshari.data.jpa.dao.StudentDAOImp;
import com.manish.keshari.data.jpa.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext(PackConfiguration.class);
		StudentDAOImp studentDAO = Context.getBean("studentDAOImp", StudentDAOImp.class);

		Student student = new Student();
		student.setName("Manish Keshari");
		student.setMobile("787982982");
		student.setAddress("Mirzapur");
		studentDAO.saveStudent(student);
		List<Student> allStudent = studentDAO.getAllStudent();
		allStudent.forEach(s -> System.out.println(s));
	}
}
