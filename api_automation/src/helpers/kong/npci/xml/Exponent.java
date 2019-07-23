package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlValue;

public class Exponent {
	private String value;

	@XmlValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
