package com.tns.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.project.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
	
	Student findByHallTicketNo(long ticketNo);

}
