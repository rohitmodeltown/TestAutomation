package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ns2:ReqSetCre")
public class Request {
	
	private String ns2;
	private String ns3;
	private Head head;
	private Txn txn;
	private Payer payer;
	private Signature signature;
	
	@XmlAttribute(name="xmlns:ns2")
	public String getNs2() {
		return ns2;
	}
	public void setNs2(String ns2) {
		this.ns2 = ns2;
	}
	
	@XmlAttribute(name="xmlns:ns3")
	public String getNs3() {
		return ns3;
	}
	public void setNs3(String ns3) {
		this.ns3 = ns3;
	}
	
	@XmlElement(name="Head")
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	
	@XmlElement(name="Txn")
	public Txn getTxn() {
		return txn;
	}
	public void setTxn(Txn txn) {
		this.txn = txn;
	}
	
	@XmlElement(name="Payer")
	public Payer getPayer() {
		return payer;
	}
	public void setPayer(Payer payer) {
		this.payer = payer;
	}
	

	@XmlElement(name="Signature")
	public Signature getSignature() {
		return signature;
	}
	public void setSignature(Signature signature) {
		this.signature = signature;
	}
	

}
