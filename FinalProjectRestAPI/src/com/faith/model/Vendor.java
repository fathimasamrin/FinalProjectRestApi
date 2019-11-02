package com.faith.model;

public class Vendor {

	
	//instances 
	
	private Integer vId; // vendor id
	private String vName; // vendor name
	private String vAddress; // vendor address
	private String vLocation; // vendor location
	private String vService; // vendor services
	private Double pincode; // pincode
	private String isActive; // available or not

	
	//constructor from superclass
	
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor using fields

	public Vendor(Integer vId, String vName, String vAddress, String vLocation, String vService, Double pincode,
			String isActive) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAddress = vAddress;
		this.vLocation = vLocation;
		this.vService = vService;
		this.pincode = pincode;
		this.isActive = isActive;
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

	
	//toString
	
	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vName=" + vName + ", vAddress=" + vAddress + ", vLocation=" + vLocation
				+ ", vService=" + vService + ", pincode=" + pincode + ", isActive=" + isActive + "]";
	}

}
