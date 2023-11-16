package com.example.web.datatransferobject;

import com.example.entity.VendorDetail;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProposalDetailsDTO {
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
	private VendorDetail vendor;

	public ProposalDetailsDTO() {

	}

	public ProposalDetailsDTO(String proposalName, String proposalCategory, String proposalDescription,
			VendorDetail vendor) {
		super();
		this.proposalName = proposalName;
		this.proposalCategory = proposalCategory;
		this.proposalDescription = proposalDescription;
		this.vendor = vendor;
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

	public VendorDetail getVendor() {
		return vendor;
	}

	public void setVendor(VendorDetail vendor) {
		this.vendor = vendor;
	}

}
