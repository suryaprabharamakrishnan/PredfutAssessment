package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proposal_details")

public class ProposalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proposal_id")
	private Long proposalNum;

	@Column(name = "proposal_name")
	private String proposalName;

	@Column(name = "proposal_category")
	private String proposalCategory;

	@Column(name = "proposal_description")
	private String proposalDescription;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_id")
	@JsonIgnoreProperties("proposalDetails")
	private VendorDetail vendor;

	@OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL)
	private List<SpecificationDetails> specificationDetails;

	public ProposalDetails() {

	}

	public ProposalDetails(String proposalName, String proposalCategory, String proposalDescription,
			VendorDetail vendor) {
		super();
		this.proposalName = proposalName;
		this.proposalCategory = proposalCategory;
		this.proposalDescription = proposalDescription;
		this.vendor = vendor;
	}

	public Long getProposalNum() {
		return proposalNum;
	}

	public void setProposalNum(Long proposalNum) {
		this.proposalNum = proposalNum;
	}

	public String getProposalName() {
		return proposalName;
	}

	public void setProposalName(String proposalName) {
		this.proposalName = proposalName;
	}

	public String getProposalCategory() {
		return proposalCategory;
	}

	public void setProposalCategory(String proposalCategory) {
		this.proposalCategory = proposalCategory;
	}

	public String getProposalDescription() {
		return proposalDescription;
	}

	public void setProposalDescription(String proposalDescription) {
		this.proposalDescription = proposalDescription;
	}

	public VendorDetail getVendorDetail() {
		return vendor;
	}

	public void setVendorDetail(VendorDetail vendor) {
		this.vendor = vendor;
	}

	public List<SpecificationDetails> getSpecificationDetails() {
		return specificationDetails;
	}

	public void setSpecificationDetails(List<SpecificationDetails> specificationDetails) {
		this.specificationDetails = specificationDetails;
	}

}
