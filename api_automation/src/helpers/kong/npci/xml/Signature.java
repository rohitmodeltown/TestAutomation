package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Signature")
public class Signature {
	
	private SignedInfo signedInfo;
	private SignatureValue signatureValue;
	private KeyInfo KeyInfo;
	private String xmlns;
	
	
	
	@XmlElement(name="SignedInfo")
	public SignedInfo getSignedInfo() {
		return signedInfo;
	}
	public void setSignedInfo(SignedInfo signedInfo) {
		this.signedInfo = signedInfo;
	}
	
	@XmlElement(name="SignatureValue")
	public SignatureValue getSignatureValue() {
		return signatureValue;
	}
	public void setSignatureValue(SignatureValue signatureValue) {
		this.signatureValue = signatureValue;
	}
	
	@XmlElement(name="KeyInfo")
	public KeyInfo getKeyInfo() {
		return KeyInfo;
	}
	public void setKeyInfo(KeyInfo keyInfo) {
		KeyInfo = keyInfo;
	}
	@XmlAttribute(name="xmlns")
	public String getXmlns() {
		return xmlns;
	}
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	
}
