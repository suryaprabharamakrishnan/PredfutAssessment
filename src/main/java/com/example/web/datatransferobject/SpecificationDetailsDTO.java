package com.example.web.datatransferobject;

import com.example.entity.ProposalDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class SpecificationDetailsDTO {

	@Column(name = "specification_name")
	private String specificationName;

	@Column(name = "specification_type")
	private String specificationType;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "specification_category")
	private String specificationCategory;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposal_id")
	private ProposalDetails proposal;

	public SpecificationDetailsDTO() {

	}

	public SpecificationDetailsDTO(String specificationName, String specificationType, String itemName,
			String specificationCategory, ProposalDetails proposal) {
		super();
		this.specificationName = specificationName;
		this.specificationType = specificationType;
		this.itemName = itemName;
		this.specificationCategory = specificationCategory;
		this.proposal = proposal;
	}

	public String getSpecName() {
		return specificationName;
	}

	public void setSpecName(String specificationName) {
		this.specificationName = specificationName;
	}

	public String getSpecificationType() {
		return specificationType;
	}

	public void setSpecificationType(String specificationType) {
		this.specificationType = specificationType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return specificationCategory;
	}

	public void setCategory(String specificationCategory) {
		this.specificationCategory = specificationCategory;
	}

	public ProposalDetails getProposal() {
		return proposal;
	}

	public void setProposal(ProposalDetails proposal) {
		this.proposal = proposal;
	}

}
