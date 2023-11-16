package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.ProposalDetails;
import com.example.entity.VendorDetail;
import com.example.repository.ProposalRepository;
import com.example.repository.VendorRepository;
import com.example.web.datatransferobject.ProposalDetailsDTO;

@Service
public class ProposalServiceImpl implements ProposalService {

	private ProposalRepository proposalRepository;
	private VendorRepository vendorRepository;

	public ProposalServiceImpl(ProposalRepository proposalRepository, VendorRepository vendorRepository) {
		super();
		this.proposalRepository = proposalRepository;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public ProposalDetails save(ProposalDetailsDTO proposalDetailsDTO) {

		VendorDetail vendor = proposalDetailsDTO.getVendor();
		VendorDetail existingVendor = vendorRepository.findByVendorId(vendor.getVendorId());
		if (existingVendor != null) {
			ProposalDetails proposal = new ProposalDetails(proposalDetailsDTO.getProposalName(),
					proposalDetailsDTO.getProposalCategory(), proposalDetailsDTO.getProposalDescription(),
					existingVendor);
			return proposalRepository.save(proposal);
		} else {
			ProposalDetails proposal = new ProposalDetails(proposalDetailsDTO.getProposalName(),
					proposalDetailsDTO.getProposalCategory(), proposalDetailsDTO.getProposalDescription(),
					proposalDetailsDTO.getVendor());
			return proposalRepository.save(proposal);
		}

	}

	@Override
	public boolean loadByProposalNum(Long proposalNum) {
		ProposalDetails proposal = proposalRepository.findByProposalNum(proposalNum);
		if (proposal != null) {
			return true;
		}
		return false;
	}

	@Override
	public String deleteProposalById(Long proposalNum) {
		proposalRepository.deleteById(proposalNum);
		return "success";
	}

	@Override
	public ProposalDetails viewByProposalId(Long proposalNum) {
		ProposalDetails proposal = proposalRepository.findByProposalNum(proposalNum);
		return proposal;
	}

	@Override
	public ProposalDetails updateProposalDetails(ProposalDetails proposalDetails) {
		ProposalDetails proposal = proposalRepository.findByProposalNum(proposalDetails.getProposalNum());
		if (proposal != null) {
			proposal.setProposalName(proposalDetails.getProposalName());
			proposal.setProposalCategory(proposalDetails.getProposalCategory());
			proposal.setProposalDescription(proposalDetails.getProposalDescription());
			return proposalRepository.save(proposal);
		}
		return proposal;
	}

	@Override
	public List<ProposalDetails> viewAllProposalDetails() {
		return proposalRepository.findAll();
	}

	@Override
	public List<ProposalDetails> filterByProposalCategory(String proposalCategory) {
		return proposalRepository.findByProposalCategory(proposalCategory);
	}

}
