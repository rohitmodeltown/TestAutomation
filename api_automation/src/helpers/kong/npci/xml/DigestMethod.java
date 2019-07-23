package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DigestMethod")
public class DigestMethod {
	
	private String algorithm;

	@XmlAttribute(name="Algorithm")
	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
