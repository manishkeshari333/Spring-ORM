package com.manish.keshari.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.keshari.data.jpa.entity.Student;

public interface StudentDataJPA extends JpaRepository<Student, Integer>{

}
