package com.tns.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.project.entity.Placement;


@Repository
public interface IPlacementRepository extends JpaRepository<Placement, Long> {

}
