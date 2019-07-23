package helpers.gateway.onboarding.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)

public class DataArea {
	@XmlElement
	public GetUserAadharProfileResponse getUserAadharProfileResponse;

	public GetUserAadharProfileResponse getGetUserAadharProfileResponse() {
		return getUserAadharProfileResponse;
	}

	public void setGetUserAadharProfileResponse(GetUserAadharProfileResponse getUserAadharProfileResponse) {
		this.getUserAadharProfileResponse = getUserAadharProfileResponse;
	}
	
}
