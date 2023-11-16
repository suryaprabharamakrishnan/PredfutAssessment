package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "specification_details")
public class SpecificationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specification_id")
	private Long specificationId;

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
	@JsonIgnoreProperties("specificationDetails")
	private ProposalDetails proposal;

	public SpecificationDetails() {

	}

	public SpecificationDetails(String specificationName, String specificationType, String itemName,
			String specificationCategory, ProposalDetails proposal) {
		super();
		this.specificationName = specificationName;
		this.specificationType = specificationType;
		this.itemName = itemName;
		this.specificationCategory = specificationCategory;
		this.proposal = proposal;
	}

	public Long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(Long specificationId) {
		this.specificationId = specificationId;
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

}
