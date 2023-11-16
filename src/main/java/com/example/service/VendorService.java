package com.example.service;

import java.util.List;

import com.example.entity.VendorDetail;
import com.example.web.datatransferobject.VendorDetailDTO;

public interface VendorService {
	public VendorDetail save(VendorDetailDTO vendorDetailDTO);

	boolean loadByVendorId(Long vendorId);

	public String deleteVendorById(Long vendorId);

	public VendorDetail viewByVendorId(Long vendorId);

	public VendorDetail updateVendorDetails(VendorDetail vendorDetail);

	public List<VendorDetail> viewAllVendorDetails();

}
