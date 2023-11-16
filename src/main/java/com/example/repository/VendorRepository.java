package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.VendorDetail;

@Repository
public interface VendorRepository extends JpaRepository<VendorDetail, Long> {
	VendorDetail findByVendorId(Long vendorId);

}
