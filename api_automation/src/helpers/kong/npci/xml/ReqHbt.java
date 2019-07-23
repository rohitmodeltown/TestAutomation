package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import helpers.kong.npci.xml.HbtMsg;
import helpers.kong.npci.xml.Head;
import helpers.kong.npci.xml.Signature;
import helpers.kong.npci.xml.Txn;

@XmlRootElement(name="ns2:ReqHbt")
public class ReqHbt {
	private String ns2;
	private Head head;
	private Txn txn;
	private HbtMsg hbtMsg;
	private Signature signature;
	
	@XmlAttribute(name="xmlns:ns2")
	public String getNs2() {
		return ns2;
	}
	public void setNs2(String ns2) {
		this.ns2 = ns2;
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
	
	@XmlElement(name="HbtMsg")
	public HbtMsg getHbtMsg() {
		return hbtMsg;
	}
	public void setHbtMsg(HbtMsg hbtMsg) {
		this.hbtMsg = hbtMsg;
	}
	
	@XmlElement(name="Signature")
	public Signature getSignature() {
		return signature;
	}
	public void setSignature(Signature signature) {
		this.signature = signature;
	}

}
