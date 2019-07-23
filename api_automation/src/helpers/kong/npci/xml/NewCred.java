package helpers.kong.npci.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="NewCred")
public class NewCred {
	private Cred1 cred1;

	@XmlElement(name="Cred")
	public Cred1 getCred1() {
		return cred1;
	}

	
	
	public void setCred1(Cred1 cred1) {
		this.cred1 = cred1;
	}

}
