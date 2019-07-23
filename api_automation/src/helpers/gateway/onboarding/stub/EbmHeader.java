package helpers.gateway.onboarding.stub;

import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class EbmHeader {
	
	@XmlElement
	private String lob;
	
	@XmlElement
	private String consumerTransactionId;
	
	@XmlElement
	private String consumerName;
	
	@XmlElement
	private String programmeName;

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getProgrammeName() {
		return programmeName;
	}

	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getConsumerTransactionId() {
		return consumerTransactionId;
	}

	public void setConsumerTransactionId() {
		this.consumerTransactionId = generateVoltTxnId();
	}
	
	public String generateVoltTxnId() {
		String txnId = Integer.toString(ThreadLocalRandom.current().nextInt(999999, 99999999));
		return txnId;
	}

}
