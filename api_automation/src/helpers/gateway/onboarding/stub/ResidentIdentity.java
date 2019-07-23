package helpers.gateway.onboarding.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class ResidentIdentity {
	@XmlElement
	private String name;
	
	@XmlElement
	private String dob;
	
	@XmlElement
	private String gender;
	
	@XmlElement
	private String phone;
	
	@XmlElement
	private String email;
	
	@XmlElement
	private String careOf;
	
	@XmlElement
	private String house;
	
	@XmlElement
	private String street;
	@XmlElement
	private String landMark;
	@XmlElement
	private String locality;
	@XmlElement
	private String vtc;
	@XmlElement
	private String subDistrict;
	@XmlElement
	private String district;
	@XmlElement
	private String state;
	@XmlElement
	private String pincode;
	@XmlElement
	private String postOfficeName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCareOf() {
		return careOf;
	}
	public void setCareOf(String careOf) {
		this.careOf = careOf;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getVtc() {
		return vtc;
	}
	public void setVtc(String vtc) {
		this.vtc = vtc;
	}
	public String getSubDistrict() {
		return subDistrict;
	}
	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPostOfficeName() {
		return postOfficeName;
	}
	public void setPostOfficeName(String postOfficeName) {
		this.postOfficeName = postOfficeName;
	}
	
}
