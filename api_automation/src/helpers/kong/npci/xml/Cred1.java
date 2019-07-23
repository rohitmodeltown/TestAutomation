package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Cred")
public class Cred1 {

	private String subType;
	private String type;
	private Data1 data1;

	@XmlAttribute(name = "subType")
	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "data")
	public Data1 getData1() {
		return data1;
	}

	public void setData1(Data1 data1) {
		this.data1 = data1;
	}

}
