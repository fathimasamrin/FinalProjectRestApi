package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.VendorContactPerson;

public class VendorContactPersonDao implements IVendorContactPerson {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// to insert vendor and contact details

	@Override
	public int insertVendorContactPersonDetails(VendorContactPerson vendorContactPerson) {
		// TODO Auto-generated method stub

		// to insert vendor details

		String sqlVen = "insert into Vendor(vName,vAddress,vLocation,vService,pincode,isActive) values('"
				+ vendorContactPerson.getvName() + "','" + vendorContactPerson.getvAddress() + "','"
				+ vendorContactPerson.getvLocation() + "','" + vendorContactPerson.getvService() + "',"
				+ vendorContactPerson.getPincode() + ",'Yes') ";
		template.update(sqlVen);

		Integer newVId = NewVendorId();

		
		
		// to insert contact details
		String sqlCon = "insert into Contact(cName,cDept,cEmail,cphone,cIsActive,cVId) values('"
				+ vendorContactPerson.getcName() + "','" + vendorContactPerson.getcDept() + "','"
				+ vendorContactPerson.getcEmail() + "'," + vendorContactPerson.getcPhone() +",'Yes',? )"; 
		return template.update(sqlCon, new Object[] { newVId });

	}

	private Integer NewVendorId() {

		String sql = "select MAX(vId)from Vendor";
		Integer seq = template.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}

	// to get all details of vendor's and contactperson's details
	@Override
	public List<VendorContactPerson> getAllDetails() {
		// TODO Auto-generated method stub
		return template.query(
				"select v.vId,v.vName,v.vAddress,v.vLocation,v.vService,v.pincode,c.cName,c.cDept,c.cEmail,c.cphone from Vendor v join Contact c"
						+ " on(v.vId=c.cVId) where v.isActive='Yes'and c.cIsActive='Yes' order by v.vId desc",
				new RowMapper<VendorContactPerson>() {
					public VendorContactPerson mapRow(ResultSet rs, int row) throws SQLException {
						VendorContactPerson vendorContactPerson = new VendorContactPerson();
						vendorContactPerson.setvId(rs.getInt(1));
						vendorContactPerson.setvName(rs.getString(2));
						vendorContactPerson.setvAddress(rs.getString(3));

						vendorContactPerson.setvLocation(rs.getString(4));
						vendorContactPerson.setvService(rs.getString(5));
						vendorContactPerson.setPincode(rs.getDouble(6));
						vendorContactPerson.setcName(rs.getString(7));
						vendorContactPerson.setcDept(rs.getString(8));
						vendorContactPerson.setcEmail(rs.getString(9));
						
						vendorContactPerson.setcPhone(rs.getLong(10));
						System.out.println("got details in dao");
						return vendorContactPerson;
					}
				});
	}

	// to disable vendor

	@Override
	public int disableVendor(int vId) {
		// TODO Auto-generated method stub
		String sql = "update vendor set isActive='no' where vId=?";
		return template.update(sql, new Object[] { vId });
	}

	@Override
	public int disableContactPerson(int cVId) {
		// TODO Auto-generated method stub
		String sql = "update contact set cIsActive='no' where cVId=?";
		return template.update(sql, new Object[] { cVId });
	}

	@Override
	public int updateVendorDetails(VendorContactPerson vendorContactPerson) {
		// TODO Auto-generated method stub
		// to update vendor table
		String sqlVen = "update vendor set vName='" + vendorContactPerson.getvName() + "',vAddress='"
				+ vendorContactPerson.getvAddress() + "',vLocation='" + vendorContactPerson.getvLocation()
				+ "',vService='" + vendorContactPerson.getvService() + "',pincode=" + vendorContactPerson.getPincode()
				+ " where vId=?";
		template.update(sqlVen, new Object[] { vendorContactPerson.getvId() });

		// to update contact table

		String sqlCon = "update contact set cName='" + vendorContactPerson.getcName() + "',cDept='"
				+ vendorContactPerson.getcDept() + "',cEmail='" + vendorContactPerson.getcEmail() + "',cphone="
				+ vendorContactPerson.getcPhone() + " where cVId=?";

		return template.update(sqlCon, new Object[] { vendorContactPerson.getvId() });
	}

	@Override
	public List<VendorContactPerson> searchVendorDetails(String searchString) {
		// TODO Auto-generated method stub
		return template.query(
				"select v.vId,v.vName,v.vAddress,v.vLocation,v.vService,v.pincode,c.cName,c.cDept,c.cPhone,c.cEmail from vendor v join contact c"
						+ " on(v.vId=c.cVId) where isActive='Yes' and v.vName LIKE '%" + searchString + "%' or v.vLocation LIKE'%"
						+ searchString + "%'",
				new RowMapper<VendorContactPerson>() {
					public VendorContactPerson mapRow(ResultSet rs, int row) throws SQLException {
						VendorContactPerson vendorContact = new VendorContactPerson();
						vendorContact.setvId(rs.getInt(1));
						vendorContact.setvName(rs.getString(2));
						vendorContact.setvLocation(rs.getString(4));
						vendorContact.setvAddress(rs.getString(3));
						vendorContact.setvService(rs.getString(5));
						vendorContact.setPincode(rs.getDouble(6));
						vendorContact.setcName(rs.getString(7));
						vendorContact.setcDept(rs.getString(8));
						vendorContact.setcPhone(rs.getLong(9));
						vendorContact.setcEmail(rs.getString(10));
						return vendorContact;
					}
				});
	}

	// to get vendor details

	@Override
	public VendorContactPerson getVendorById(int vId) {
		// TODO Auto-generated method stub
		String sql = "select v.vId,v.vName,v.vAddress,v.vLocation,v.vService,v.pincode,c.cName,c.cDept,c.cEmail,c.cPhone from Vendor v join Contact c"
				+ " on(v.vId=c.cVId) where v.isActive='Yes'and c.cIsActive='Yes' and v.vId=?";
		return template.queryForObject(sql, new Object[] { vId },
				new BeanPropertyRowMapper<VendorContactPerson>(VendorContactPerson.class));
	}

	@Override
	public VendorContactPerson duplication(Long cPhone, String cEmail) {
		// TODO Auto-generated method stub
		String sql="select c.cemail,c.cphone from vendor v join contact c on (v.vid=c.cvid) where (c.cphone=? or c.cemail=?) and v.isactive='Yes'";
		return template.queryForObject(sql, new Object[] { cPhone,cEmail},
				new BeanPropertyRowMapper<VendorContactPerson>(VendorContactPerson.class));
	}
	
	
	
	

}
