package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="KeyInfo")
public class KeyInfo {
	
	private KeyValue keyValue;

	@XmlElement(name="KeyValue")
	public KeyValue getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(KeyValue keyValue) {
		this.keyValue = keyValue;
	}

}
