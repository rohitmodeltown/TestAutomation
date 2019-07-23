package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Cred")
public class Cred {
	private String subType;
	private String type;
	private Data data;
	@XmlAttribute(name="subType")
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	
	@XmlAttribute(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name="data")
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}

}
