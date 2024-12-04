package com.tns.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.project.entity.Certificate;
import com.tns.project.entity.College;


@Repository
public interface ICertificateRepository extends JpaRepository<Certificate, Long> {

	Certificate findByYearAndCollege(int id, College college);

}
