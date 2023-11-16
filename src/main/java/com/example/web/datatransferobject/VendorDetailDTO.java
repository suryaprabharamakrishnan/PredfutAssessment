package com.example.web.datatransferobject;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class VendorDetailDTO {

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

	public VendorDetailDTO() {

	}

	public VendorDetailDTO(String vendorName, String vendorType, int score) {
		super();
		this.vendorName = vendorName;
		this.vendorType = vendorType;
		this.score = score;
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
