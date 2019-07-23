package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RSAKeyValue")
public class RSAKeyValue {
	private Modulus modulus;
	private Exponent exponent;
	
	@XmlElement(name="Modulus")
	public Modulus getModulus() {
		return modulus;
	}
	public void setModulus(Modulus modulus) {
		this.modulus = modulus;
	}
	
	@XmlElement(name="Exponent")
	public Exponent getExponent() {
		return exponent;
	}
	public void setExponent(Exponent exponent) {
		this.exponent = exponent;
	}
}
