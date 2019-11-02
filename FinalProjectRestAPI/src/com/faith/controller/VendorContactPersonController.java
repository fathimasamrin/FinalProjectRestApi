package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IVendorContactPerson;
import com.faith.model.VendorContactPerson;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class VendorContactPersonController {

	@Autowired
	private IVendorContactPerson dao;

	// get all details

	@RequestMapping(value = "/vendorcontactdetails", method = RequestMethod.GET)
	public List getDetails() {
		List list;
		System.out.println("Get all  details");
		list = dao.getAllDetails();
		return list;
	}
	
	// insert vendorcontact details
	@RequestMapping(value = "/insertvendordetails", method = RequestMethod.POST)
	public void insertDetails(@RequestBody VendorContactPerson vendorContactPerson) {
		dao.insertVendorContactPersonDetails(vendorContactPerson);
	}

	// update

	@RequestMapping(value = "/updatevendorbyid/{vId}", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody VendorContactPerson vendorContactPerson) {
		dao.updateVendorDetails(vendorContactPerson);
	}

	// disable vendor

	@RequestMapping(value = "/disablevendor/{vId}", method = RequestMethod.PUT)
	void disableVendor(@PathVariable("vId") int vId) {
		dao.disableVendor(vId);
	}

	// disable contact

	@RequestMapping(value = "/disablecontact/{Id}", method = RequestMethod.PUT)
	void disableContact(@PathVariable("cVId") int cVId) {
		dao.disableVendor(cVId);
	}

	// search

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/vendordetails/{searchString}", method = RequestMethod.GET)
	public List getVendorDetails(@PathVariable("searchString") String searchString) {
		List list;
		if (searchString.equals("null")) {
			list = dao.getAllDetails();
		} else {
			list = dao.searchVendorDetails(searchString);
		}
		return list;
	}

	// get vendor by id

	@RequestMapping(value = "/vendorbyid/{vId}", method = RequestMethod.GET)
	public VendorContactPerson getVendorById(@PathVariable("vId") int vId) {
		VendorContactPerson vendorContactPerson = dao.getVendorById(vId);
		return vendorContactPerson;
	}
	
	@RequestMapping(value="/duplication/{cphone}/{cemail}",method = RequestMethod.GET)
	public VendorContactPerson duplication(@PathVariable(value="cPhone")Long cPhone,
			@PathVariable(value="cEmail")String cEmail){
		VendorContactPerson vendorContactPerson= (VendorContactPerson)dao.duplication(cPhone,cEmail);
		return vendorContactPerson;
		
	}

}
