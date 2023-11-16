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

import com.example.entity.ProposalDetails;
import com.example.service.ProposalService;
import com.example.web.datatransferobject.ProposalDetailsDTO;

@Controller
@RequestMapping("/proposal")
public class ProposalController {

	private ProposalService proposalService;

	public ProposalController(ProposalService proposalService) {
		super();
		this.proposalService = proposalService;
	}

	@PostMapping("/create")
	public ResponseEntity<ProposalDetails> createProposal(@RequestBody ProposalDetailsDTO proposalDetailsDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(proposalService.save(proposalDetailsDTO));
	}

	@PostMapping("/update")
	public ResponseEntity<ProposalDetails> updateProposal(@RequestBody ProposalDetails proposalDetails) {
		ProposalDetails proposal = proposalService.updateProposalDetails(proposalDetails);
		return ResponseEntity.status(HttpStatus.OK).body(proposal);
	}

	@GetMapping("/viewProposalDetailById/{proposalNum}")
	public ResponseEntity<ProposalDetails> viewProposalById(@PathVariable Long proposalNum) {
		ProposalDetails proposal = proposalService.viewByProposalId(proposalNum);
		if (proposal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(proposal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping("/viewAllProposalDetails")
	public ResponseEntity<List<ProposalDetails>> viewAllProposalDetails() {
		List<ProposalDetails> proposal = proposalService.viewAllProposalDetails();
		return ResponseEntity.ok(proposal);
	}

	@GetMapping("/filterByProposalCategory/{proposalCategory}")
	public ResponseEntity<List<ProposalDetails>> filterByCategory(@PathVariable String proposalCategory) {
		return ResponseEntity.ok(proposalService.filterByProposalCategory(proposalCategory));
	}

	@PostMapping("/delete/{proposalNum}")
	public ResponseEntity<ProposalDetails> deleteProposal(@PathVariable Long proposalNum) {
		ProposalDetails proposal = proposalService.viewByProposalId(proposalNum);
		if (proposal != null) {
			proposalService.deleteProposalById(proposalNum);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
