package com.example.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.VendorDetail;
import com.example.service.VendorService;
import com.example.web.datatransferobject.VendorDetailDTO;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	private VendorService vendorService;

	public VendorController(VendorService vendorService) {
		super();
		this.vendorService = vendorService;
	}

	@PostMapping("/create")
	public ResponseEntity<VendorDetail> createVendor(@RequestBody VendorDetailDTO vendorDetailDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.save(vendorDetailDTO));
	}

	@PostMapping("/update")
	public ResponseEntity<VendorDetail> updateVendor(@RequestBody VendorDetail vendorDetail) {
		VendorDetail vendor = vendorService.updateVendorDetails(vendorDetail);
		return ResponseEntity.status(HttpStatus.OK).body(vendor);
	}

	@GetMapping("/viewVendorDetailById/{vendorId}")
	public ResponseEntity<VendorDetail> viewVendorById(@PathVariable Long vendorId) {
		VendorDetail vendor = vendorService.viewByVendorId(vendorId);
		if (vendor != null) {
			return ResponseEntity.status(HttpStatus.OK).body(vendor);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/viewAllVendorDetails")
	public ResponseEntity<List<VendorDetail>> viewAllVendorDetail() {
		List<VendorDetail> specification = vendorService.viewAllVendorDetails();
		return ResponseEntity.ok(specification);
	}

	@PostMapping("/delete/{vendorId}")
	public ResponseEntity<VendorDetail> deleteVendor(@PathVariable Long vendorId) {
		VendorDetail vendor = vendorService.viewByVendorId(vendorId);
		if (vendor != null) {
			vendorService.deleteVendorById(vendorId);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
