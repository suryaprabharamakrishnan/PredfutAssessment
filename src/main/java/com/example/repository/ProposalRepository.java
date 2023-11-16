package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ProposalDetails;

@Repository
public interface ProposalRepository extends JpaRepository<ProposalDetails, Long> {

	ProposalDetails findByProposalNum(Long proposalNum);

	List<ProposalDetails> findByProposalCategory(String proposalCategory);
}
