package helpers.gateway.onboarding.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="getAadhaarProfileResponse")
@XmlAccessorType(XmlAccessType.FIELD)

public class GetAadhaarProfileResponse {
	@XmlElement
	public EbmHeader ebmHeader;
	
	@XmlElement
	public DataArea dataArea;
	
	public EbmHeader getEbmHeader() {
		return ebmHeader;
	}
	public void setEbmHeader(EbmHeader ebmHeader) {
		this.ebmHeader = ebmHeader;
	}
	public DataArea getDataArea() {
		return dataArea;
	}
	public void setDataArea(DataArea dataArea) {
		this.dataArea = dataArea;
	}
}
