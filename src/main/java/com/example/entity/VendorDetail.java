package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_details")
public class VendorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	private Long vendorId;

	@Column(name = "vendor_name")
	private String vendorName;

	@Column(name = "vendor_type")
	private String vendorType;

	@Column(name = "score")
	private int score;

	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	private List<ProposalDetails> proposalDetails;

	public VendorDetail() {

	}

	public VendorDetail(String vendorName, String vendorType, int score) {
		super();
		this.vendorName = vendorName;
		this.vendorType = vendorType;
		this.score = score;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
