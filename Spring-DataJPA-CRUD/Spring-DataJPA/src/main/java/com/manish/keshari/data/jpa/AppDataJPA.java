package com.manish.keshari.data.jpa;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manish.keshari.data.jpa.config.PackConfiguration;
import com.manish.keshari.data.jpa.dao.StudentDataJPA;
import com.manish.keshari.data.jpa.entity.Student;

public class AppDataJPA {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext(PackConfiguration.class);
		StudentDataJPA studentDataJPA = Context.getBean("studentDataJPA", StudentDataJPA.class);

		// save Student
		Student student = new Student();
		student.setName("Manish Keshari");
		student.setMobile("787982982");
		student.setAddress("Mirzapur");
		studentDataJPA.save(student);

		// get All Student
		List<Student> allStudent = studentDataJPA.findAll();
		allStudent.forEach(s -> System.out.println(s));
	}

}
