package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.ProposalDetails;
import com.example.entity.SpecificationDetails;
import com.example.repository.ProposalRepository;
import com.example.repository.SpecificationRepository;
import com.example.web.datatransferobject.SpecificationDetailsDTO;

@Service
public class SpecificationServiceImpl implements SpecificationService {

	private SpecificationRepository specificationRepository;
	private ProposalRepository proposalRepository;

	public SpecificationServiceImpl(SpecificationRepository specificationRepository,
			ProposalRepository proposalRepository) {
		super();
		this.specificationRepository = specificationRepository;
		this.proposalRepository = proposalRepository;
	}

	@Override
	public SpecificationDetails save(SpecificationDetailsDTO specificationDetailsDTO) {

		ProposalDetails proposal = specificationDetailsDTO.getProposal();
		ProposalDetails existingProposal = proposalRepository.findByProposalNum(proposal.getProposalNum());
		if (existingProposal != null) {
			SpecificationDetails specification = new SpecificationDetails(specificationDetailsDTO.getSpecName(),
					specificationDetailsDTO.getSpecificationType(), specificationDetailsDTO.getItemName(),
					specificationDetailsDTO.getCategory(), existingProposal);
			return specificationRepository.save(specification);
		} else {
			SpecificationDetails specification = new SpecificationDetails(specificationDetailsDTO.getSpecName(),
					specificationDetailsDTO.getSpecificationType(), specificationDetailsDTO.getItemName(),
					specificationDetailsDTO.getCategory(), specificationDetailsDTO.getProposal());
			return specificationRepository.save(specification);
		}

	}

	@Override
	public boolean loadBySpecificationId(Long specificationId) {
		SpecificationDetails specification = specificationRepository.findBySpecificationId(specificationId);
		if (specification != null) {
			return true;
		}
		return false;
	}

	@Override
	public String deleteSpecificationById(Long specificationId) {
		specificationRepository.deleteById(specificationId);
		return "success";
	}

	@Override
	public SpecificationDetails viewBySpecificationId(Long specificationId) {
		SpecificationDetails specification = specificationRepository.findBySpecificationId(specificationId);
		return specification;
	}

	@Override
	public SpecificationDetails updateSpecificationDetails(SpecificationDetails specificationDetails) {
		SpecificationDetails specification = specificationRepository
				.findBySpecificationId(specificationDetails.getSpecificationId());
		if (specification != null) {
			specification.setSpecName(specificationDetails.getSpecName());
			specification.setItemName(specificationDetails.getItemName());
			specification.setSpecificationType(specificationDetails.getSpecificationType());
			specification.setCategory(specificationDetails.getCategory());
			return specificationRepository.save(specification);
		}
		return specification;
	}

	@Override
	public List<SpecificationDetails> viewAllSpecificationDetails() {
		return specificationRepository.findAll();
	}

}
