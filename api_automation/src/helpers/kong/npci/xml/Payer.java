package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Payer")
public class Payer {
	private String addr;
	private String code;
	private String name;
	private String seqNum;
	private String type;
	private Device device;
	private Ac ac;
	private Creds creds;
	private NewCred newCred;
	private Info info;
	
	@XmlElement(name="Info")
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@XmlAttribute(name="addr")
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@XmlAttribute(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name="seqNum")
	public String getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}
	
	@XmlAttribute(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name="Device")
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	
	@XmlElement(name="Ac")
	public Ac getAc() {
		return ac;
	}
	public void setAc(Ac ac) {
		this.ac = ac;
	}
	
	@XmlElement(name="Creds")
	public Creds getCreds() {
		return creds;
	}
	public void setCreds(Creds creds) {
		this.creds = creds;
	}
	
	@XmlElement(name="NewCred")
	public NewCred getNewCred() {
		return newCred;
	}
	public void setNewCred(NewCred newCred) {
		this.newCred = newCred;
	}
	
	
	

}
