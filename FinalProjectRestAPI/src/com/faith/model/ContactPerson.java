package com.faith.model;

public class ContactPerson {
	
	private Integer cId; // contact person's id
	private String cName ;// name
	private Integer cVId ;//vendor id
	private String cDept; //department
	private String cEmail; //email
	private Double cPhone ; // phone number
	private String cIsActive; //available or not
	
	//constructor from superclass
	
	public ContactPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	//constructor using fields
	public ContactPerson(Integer cId, String cName, Integer cVId, String cDept, String cEmail, Double cPhone,
			String cIsActive) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cVId = cVId;
		this.cDept = cDept;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cIsActive = cIsActive;
	}

	//getters and setters
	
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

	public Double getcPhone() {
		return cPhone;
	}

	public void setcPhone(Double cPhone) {
		this.cPhone = cPhone;
	}

	public String getcIsActive() {
		return cIsActive;
	}

	public void setcIsActive(String cIsActive) {
		this.cIsActive = cIsActive;
	}

	
	//tostring 
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", cName=" + cName + ", cVId=" + cVId + ", cDept=" + cDept + ", cEmail=" + cEmail
				+ ", cPhone=" + cPhone + ", cIsActive=" + cIsActive + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
