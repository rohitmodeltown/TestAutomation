package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Reference")
public class Reference {
	
	private String uri;
	private Transforms transforms;
	private DigestMethod digestMethod;
	private DigestValue digestValue;
	
	@XmlAttribute(name="URI")
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@XmlElement(name="Transforms")
	public Transforms getTransforms() {
		return transforms;
	}
	public void setTransforms(Transforms transforms) {
		this.transforms = transforms;
	}
	
	@XmlElement(name="DigestMethod")
	public DigestMethod getDigestMethod() {
		return digestMethod;
	}
	public void setDigestMethod(DigestMethod digestMethod) {
		this.digestMethod = digestMethod;
	}
	
	@XmlElement(name="DigestValue")
	public DigestValue getDigestValue() {
		return digestValue;
	}
	public void setDigestValue(DigestValue digestValue) {
		this.digestValue = digestValue;
	}

}
