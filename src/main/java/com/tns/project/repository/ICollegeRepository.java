package com.tns.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tns.project.entity.College;
import com.tns.project.entity.Placement;


@Repository
public interface ICollegeRepository extends JpaRepository<College, Long>{


	
}
