package com.example.service;

import java.util.List;

import com.example.entity.SpecificationDetails;
import com.example.web.datatransferobject.SpecificationDetailsDTO;

public interface SpecificationService {

	public SpecificationDetails save(SpecificationDetailsDTO specificationDetailsDTO);

	boolean loadBySpecificationId(Long specificationId);

	public String deleteSpecificationById(Long specificationId);

	public SpecificationDetails viewBySpecificationId(Long specificationId);

	public SpecificationDetails updateSpecificationDetails(SpecificationDetails specificationDetails);

	public List<SpecificationDetails> viewAllSpecificationDetails();

}
