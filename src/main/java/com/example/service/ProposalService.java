package com.example.service;

import java.util.List;

import com.example.entity.ProposalDetails;
import com.example.web.datatransferobject.ProposalDetailsDTO;

public interface ProposalService {
	public ProposalDetails save(ProposalDetailsDTO ProposalDetailsDTO);

	boolean loadByProposalNum(Long proposalNum);

	public String deleteProposalById(Long proposalNum);

	public ProposalDetails viewByProposalId(Long proposalNum);

	public ProposalDetails updateProposalDetails(ProposalDetails proposalDetail);

	public List<ProposalDetails> viewAllProposalDetails();

	public List<ProposalDetails> filterByProposalCategory(String proposalCategory);

}
