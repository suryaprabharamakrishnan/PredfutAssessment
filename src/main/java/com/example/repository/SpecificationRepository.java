package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.SpecificationDetails;

@Repository
public interface SpecificationRepository extends JpaRepository<SpecificationDetails, Long> {

	SpecificationDetails findBySpecificationId(Long specificationId);

}
