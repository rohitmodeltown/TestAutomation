package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Rating")
public class Rating {
	private String verifiedAddress;

	@XmlAttribute(name="verifiedAddress")
	public String getVerifiedAddress() {
		return verifiedAddress;
	}

	public void setVerifiedAddress(String verifiedAddress) {
		this.verifiedAddress = verifiedAddress;
	}
}
