package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="KeyValue")
public class KeyValue {
	
	private RSAKeyValue rsaKeyValue;

	@XmlElement(name="RSAKeyValue")
	public RSAKeyValue getRsaKeyValue() {
		return rsaKeyValue;
	}

	public void setRsaKeyValue(RSAKeyValue rsaKeyValue) {
		this.rsaKeyValue = rsaKeyValue;
	}

}
