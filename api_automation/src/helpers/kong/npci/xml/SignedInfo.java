package helpers.kong.npci.xml;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SignedInfo")
public class SignedInfo {
	
	private CanonicalizationMethod canonicalizationMethod;
	private SignatureMethod signatureMethod;
	private Reference reference;
	
	@XmlElement(name="CanonicalizationMethod")
	public CanonicalizationMethod getCanonicalizationMethod() {
		return canonicalizationMethod;
	}
	public void setCanonicalizationMethod(CanonicalizationMethod canonicalizationMethod) {
		this.canonicalizationMethod = canonicalizationMethod;
	}
	
	@XmlElement(name="SignatureMethod")
	public SignatureMethod getSignatureMethod() {
		return signatureMethod;
	}
	public void setSignatureMethod(SignatureMethod signatureMethod) {
		this.signatureMethod = signatureMethod;
	}
	
	@XmlElement(name="Reference")
	public Reference getReference() {
		return reference;
	}
	public void setReference(Reference reference) {
		this.reference = reference;
	}
	

}
