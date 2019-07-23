package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Creds")
public class Creds {
	private Cred cred;
	private Data data;

	

	@XmlElement(name="Cred")
	public Cred getCred() {
		return cred;
	}

	public void setCred(Cred cred) {
		this.cred = cred;
	}
	
	@XmlElement(name="Data")
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
