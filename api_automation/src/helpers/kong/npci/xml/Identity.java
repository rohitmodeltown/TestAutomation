package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Identity")
public class Identity {
	private String identityId;
	private String IdentityType;
	private String verifiedName;
	
	@XmlAttribute(name="id")
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	
	@XmlAttribute(name="type")
	public String getIdentityType() {
		return IdentityType;
	}
	public void setIdentityType(String identityType) {
		IdentityType = identityType;
	}
	
	@XmlAttribute(name="verifiedName")
	public String getVerifiedName() {
		return verifiedName;
	}
	public void setVerifiedName(String verifiedName) {
		this.verifiedName = verifiedName;
	}
	

}
