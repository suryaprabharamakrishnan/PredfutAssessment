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

import com.example.entity.SpecificationDetails;
import com.example.service.SpecificationService;
import com.example.web.datatransferobject.SpecificationDetailsDTO;

@Controller
@RequestMapping("/specification")
public class SpecificationController {

	private SpecificationService specificationService;

	public SpecificationController(SpecificationService specificationService) {
		super();
		this.specificationService = specificationService;
	}

	@PostMapping("/create")
	public ResponseEntity<SpecificationDetails> createSpecification(
			@RequestBody SpecificationDetailsDTO specificationDetailsDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(specificationService.save(specificationDetailsDTO));
	}

	@PostMapping("/update")
	public ResponseEntity<SpecificationDetails> updateSpecification(
			@RequestBody SpecificationDetails specificationDetails) {
		SpecificationDetails specification = specificationService.updateSpecificationDetails(specificationDetails);
		return ResponseEntity.status(HttpStatus.OK).body(specification);
	}

	@GetMapping("/viewSpecificationDetailById/{specificationNum}")
	public ResponseEntity<SpecificationDetails> viewSpecificationById(@PathVariable Long specificationNum) {
		SpecificationDetails specification = specificationService.viewBySpecificationId(specificationNum);
		if (specification != null) {
			return ResponseEntity.status(HttpStatus.OK).body(specification);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/viewAllSpecificationDetails")
	public ResponseEntity<List<SpecificationDetails>> viewAllSpecificationDetail() {
		List<SpecificationDetails> specification = specificationService.viewAllSpecificationDetails();
		return ResponseEntity.ok(specification);
	}

	@PostMapping("/delete/{specificationNum}")
	public ResponseEntity<SpecificationDetails> deleteSpecification(@PathVariable Long specificationNum) {
		SpecificationDetails specification = specificationService.viewBySpecificationId(specificationNum);
		if (specification != null) {
			specificationService.deleteSpecificationById(specificationNum);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}