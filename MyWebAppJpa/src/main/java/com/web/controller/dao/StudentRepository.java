package com.web.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.controller.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByTech(String tech);
//	
//	List<Student> findBySidGreaterThan(int sid);
//	
//	@Query("from Student where tech=?1 order by sname")
//	List<Student> findByTechSorted(String tech);
}
