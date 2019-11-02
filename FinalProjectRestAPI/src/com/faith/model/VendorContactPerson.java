package com.faith.model;

public class VendorContactPerson {
	
	private Integer vId; // vendor id
	private String vName; // vendor name
	private String vAddress; // vendor address
	private String vLocation; // vendor location
	private String vService; // vendor services
	private Double pincode; // pincode
	private String isActive; // available or not
	private Integer cId; // contact person's id
	private String cName ;// contact person's name
	private Integer cVId ;//vendor id references
	private String cDept; //department of contactperson
	private String cEmail; //email of contact person
	private Long cPhone ; // phone number of contact person
	private String cIsActive; // contact person available or not
	
	//constructor from superclass
	public VendorContactPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//constructor using fields

	public VendorContactPerson(Integer vId, String vName, String vAddress, String vLocation, String vService,
			Double pincode, String isActive, Integer cId, String cName, Integer cVId, String cDept, String cEmail,
			Long cPhone, String cIsActive) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAddress = vAddress;
		this.vLocation = vLocation;
		this.vService = vService;
		this.pincode = pincode;
		this.isActive = isActive;
		this.cId = cId;
		this.cName = cName;
		this.cVId = cVId;
		this.cDept = cDept;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cIsActive = cIsActive;
	}

	
	//getters and setters

	public Integer getvId() {
		return vId;
	}


	public void setvId(Integer vId) {
		this.vId = vId;
	}


	public String getvName() {
		return vName;
	}


	public void setvName(String vName) {
		this.vName = vName;
	}


	public String getvAddress() {
		return vAddress;
	}


	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}


	public String getvLocation() {
		return vLocation;
	}


	public void setvLocation(String vLocation) {
		this.vLocation = vLocation;
	}


	public String getvService() {
		return vService;
	}


	public void setvService(String vService) {
		this.vService = vService;
	}


	public Double getPincode() {
		return pincode;
	}


	public void setPincode(Double pincode) {
		this.pincode = pincode;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public Integer getcId() {
		return cId;
	}


	public void setcId(Integer cId) {
		this.cId = cId;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public Integer getcVId() {
		return cVId;
	}


	public void setcVId(Integer cVId) {
		this.cVId = cVId;
	}


	public String getcDept() {
		return cDept;
	}


	public void setcDept(String cDept) {
		this.cDept = cDept;
	}


	public String getcEmail() {
		return cEmail;
	}


	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}


	public Long getcPhone() {
		return cPhone;
	}


	public void setcPhone(Long cPhone) {
		this.cPhone = cPhone;
	}


	public String getcIsActive() {
		return cIsActive;
	}


	public void setcIsActive(String cIsActive) {
		this.cIsActive = cIsActive;
	}

	//to string
	@Override
	public String toString() {
		return "VendorContactPerson [vId=" + vId + ", vName=" + vName + ", vAddress=" + vAddress + ", vLocation="
				+ vLocation + ", vService=" + vService + ", pincode=" + pincode + ", isActive=" + isActive + ", cId="
				+ cId + ", cName=" + cName + ", cVId=" + cVId + ", cDept=" + cDept + ", cEmail=" + cEmail + ", cPhone="
				+ cPhone + ", cIsActive=" + cIsActive + "]";
	}
	
	
	
	
	

	
	
	
	

	
	
	

}
