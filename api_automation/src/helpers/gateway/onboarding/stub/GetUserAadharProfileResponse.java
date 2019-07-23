package helpers.gateway.onboarding.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)

public class GetUserAadharProfileResponse {
	@XmlElement
	public Status status;
	@XmlElement
	public String responseCode;
	@XmlElement
	public String responseTimeStamp;
	@XmlElement
	public String action;
	@XmlElement
	public ResidentIdentity residentIdentity;
	@XmlElement
	public String photo;
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseTimeStamp() {
		return responseTimeStamp;
	}
	public void setResponseTimeStamp(String responseTimeStamp) {
		this.responseTimeStamp = responseTimeStamp;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public ResidentIdentity getResidentIdentity() {
		return residentIdentity;
	}
	public void setResidentIdentity(ResidentIdentity residentIdentity) {
		this.residentIdentity = residentIdentity;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
