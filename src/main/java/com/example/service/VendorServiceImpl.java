package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.VendorDetail;
import com.example.repository.VendorRepository;
import com.example.web.datatransferobject.VendorDetailDTO;

@Service
public class VendorServiceImpl implements VendorService {

	private VendorRepository vendorRepository;

	public VendorServiceImpl(VendorRepository vendorRepository) {
		super();
		this.vendorRepository = vendorRepository;

	}

	@Override
	public VendorDetail save(VendorDetailDTO vendorDetailDTO) {

		VendorDetail vendor = new VendorDetail(vendorDetailDTO.getVendorName(), vendorDetailDTO.getVendorType(),
				vendorDetailDTO.getScore());
		return vendorRepository.save(vendor);

	}

	@Override
	public boolean loadByVendorId(Long vendorId) {
		VendorDetail vendor = vendorRepository.findByVendorId(vendorId);
		if (vendor != null) {
			return true;
		}
		return false;
	}

	@Override
	public String deleteVendorById(Long vendorId) {
		vendorRepository.deleteById(vendorId);
		return "success";
	}

	@Override
	public VendorDetail viewByVendorId(Long vendorId) {
		VendorDetail vendor = vendorRepository.findByVendorId(vendorId);
		return vendor;
	}

	@Override
	public VendorDetail updateVendorDetails(VendorDetail vendorDetail) {
		VendorDetail vendor = vendorRepository.findByVendorId(vendorDetail.getVendorId());
		if (vendor != null) {
			vendor.setVendorName(vendorDetail.getVendorName());
			vendor.setVendorType(vendorDetail.getVendorType());
			vendor.setScore(vendorDetail.getScore());
			return vendorRepository.save(vendor);
		}
		return vendor;
	}

	@Override
	public List<VendorDetail> viewAllVendorDetails() {
		return vendorRepository.findAll();
	}

}
