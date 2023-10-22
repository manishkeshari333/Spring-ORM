package com.manish.keshari.data.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manish.keshari.data.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImp {

//	@PersistenceContext(unitName = "manish")
	@Autowired
	EntityManager entityManager;

	@Transactional
	public void saveStudent(Student student) {
		entityManager.persist(student);
		System.out.println("Student is added");

	}

	public List<Student> getAllStudent() {
		TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
		List<Student> resultList = query.getResultList();
		return resultList;
	}

}
