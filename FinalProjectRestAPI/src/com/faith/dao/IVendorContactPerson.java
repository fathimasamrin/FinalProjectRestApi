package com.faith.dao;

import java.util.List;

import com.faith.model.VendorContactPerson;

public interface IVendorContactPerson {
	
	public abstract int insertVendorContactPersonDetails(VendorContactPerson vendorContactPerson);
	
	public abstract List<VendorContactPerson> getAllDetails();
	
	public abstract int disableVendor(int vId);
	public abstract int disableContactPerson(int cVId);
	
	public abstract int updateVendorDetails(VendorContactPerson vendorContactPerson);
	
	
	public abstract List<VendorContactPerson> searchVendorDetails(String searchString);
	
	public abstract VendorContactPerson getVendorById(int vId);
	
	public abstract VendorContactPerson duplication(Long cPhone,String cEmail) ;
	

}
