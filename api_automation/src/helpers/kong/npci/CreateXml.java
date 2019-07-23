package helpers.kong.npci;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import helpers.kong.npci.xml.ReqHbt;

import helpers.kong.npci.xml.Ac;
import helpers.kong.npci.xml.CanonicalizationMethod;
import helpers.kong.npci.xml.Cred;
import helpers.kong.npci.xml.Cred1;
import helpers.kong.npci.xml.Creds;
import helpers.kong.npci.xml.Data;
import helpers.kong.npci.xml.Data1;
import helpers.kong.npci.xml.Detail;
import helpers.kong.npci.xml.Device;
import helpers.kong.npci.xml.DigestMethod;
import helpers.kong.npci.xml.DigestValue;
import helpers.kong.npci.xml.Exponent;
import helpers.kong.npci.xml.HbtMsg;
import helpers.kong.npci.xml.Head;
import helpers.kong.npci.xml.Identity;
import helpers.kong.npci.xml.Info;
import helpers.kong.npci.xml.KeyInfo;
import helpers.kong.npci.xml.KeyValue;
import helpers.kong.npci.xml.Link;
import helpers.kong.npci.xml.Modulus;
import helpers.kong.npci.xml.NewCred;
import helpers.kong.npci.xml.Payer;
import helpers.kong.npci.xml.RSAKeyValue;
import helpers.kong.npci.xml.Rating;
import helpers.kong.npci.xml.Reference;
import helpers.kong.npci.xml.ReqBalEnq;
import helpers.kong.npci.xml.ReqListAccount;
import helpers.kong.npci.xml.ReqOtp;
import helpers.kong.npci.xml.ReqSetCre;
import helpers.kong.npci.xml.Signature;
import helpers.kong.npci.xml.SignatureMethod;
import helpers.kong.npci.xml.SignatureValue;
import helpers.kong.npci.xml.SignedInfo;
import helpers.kong.npci.xml.Tag;
import helpers.kong.npci.xml.Transform;
import helpers.kong.npci.xml.Transforms;
import helpers.kong.npci.xml.Txn;

public class CreateXml {

	public String createXML(Hashtable<String, String> map, String api) {
		String xmlString = null;
		Ac ac = new Ac();
		CanonicalizationMethod canonicalizationMethod = new CanonicalizationMethod();
		Creds creds = new Creds();
		Data data = new Data();
		Cred cred = new Cred();
		NewCred newCred = new NewCred();
		Data1 data1 = new Data1();
		Cred1 cred1 = new Cred1();
		Device device = new Device();
		DigestMethod digestMethod = new DigestMethod();
		Head head = new Head();
		Identity identity = new Identity();
		Info info = new Info();
		KeyInfo keyInfo = new KeyInfo();
		KeyValue keyValue = new KeyValue();
		Link link = new Link();
		HbtMsg hbtMsg = new HbtMsg();
		Payer payer = new Payer();
		Rating rating = new Rating();
		Reference reference = new Reference();
		ReqSetCre reqSetCre = new ReqSetCre();
		ReqBalEnq reqBalEnq = new ReqBalEnq();
		ReqOtp reqOtp = new ReqOtp();
		ReqListAccount reqListAccount = new ReqListAccount();
		RSAKeyValue rsaKeyValue = new RSAKeyValue();
		Signature signature = new Signature();
		SignatureMethod signatureMethod = new SignatureMethod();
		DigestValue digestValue = new DigestValue();
		SignedInfo signedInfo = new SignedInfo();
		SignatureValue signatureValue = new SignatureValue();
		Modulus modulus = new Modulus();
		Exponent exponent = new Exponent();
		ReqHbt reqHbt = new ReqHbt();
		Tag tag1 = new Tag();
		Tag tag2 = new Tag();
		Tag tag3 = new Tag();
		Tag tag4 = new Tag();
		Tag tag5 = new Tag();
		Tag tag6 = new Tag();
		Tag tag7 = new Tag();
		Tag tag8 = new Tag();
		Tag tag9 = new Tag();
		Detail detail1 = new Detail();
		Detail detail2 = new Detail();
		Detail detail3 = new Detail();
		Txn txn = new Txn();
		Transform transform = new Transform();
		Transforms transforms = new Transforms();
		Set keys = map.keySet();
		Iterator itr = keys.iterator();
		String key;
		String value;
		while (itr.hasNext()) {
			key = (String) itr.next();
			value = (String) map.get(key);

			if (key.equals("mobile_name")) {
				tag1.setTagName(value);
			} else if (key.equals("mobile_value")) {
				tag1.setTagValue(value);
			} else if (key.equals("geocode_name")) {
				tag2.setTagName(value);
			} else if (key.equals("geocode_value")) {
				tag2.setTagValue(value);
			} else if (key.equals("location_name")) {
				tag3.setTagName(value);
			} else if (key.equals("location_value")) {
				tag3.setTagValue(value);
			} else if (key.equals("ip_name")) {
				tag4.setTagName(value);
			} else if (key.equals("ip_value")) {
				tag4.setTagValue(value);
			} else if (key.equals("type_name")) {
				tag5.setTagName(value);
			} else if (key.equals("type_value")) {
				tag5.setTagValue(value);
			} else if (key.equals("id_name")) {
				tag6.setTagName(value);
			} else if (key.equals("id_value")) {
				tag6.setTagValue(value);
			} else if (key.equals("os_name")) {
				tag7.setTagName(value);
			} else if (key.equals("os_value")) {
				tag7.setTagValue(value);
			} else if (key.equals("app_name")) {
				tag8.setTagName(value);
			} else if (key.equals("app_value")) {
				tag8.setTagValue(value);
			} else if (key.equals("capability_name")) {
				tag9.setTagName(value);
			} else if (key.equals("capability_value")) {
				tag9.setTagValue(value);
			} else if (key.equals("addrType")) {
				ac.setAddrType(value);
			} else if (key.equals("ifsc_name")) {
				detail1.setDetailName(value);
			} else if (key.equals("ifsc_value")) {
				detail1.setDetailValue(value);
			} else if (key.equals("actype_name")) {
				detail2.setDetailName(value);
			} else if (key.equals("actype_value")) {
				detail2.setDetailValue(value);
			} else if (key.equals("acnum_name")) {
				detail3.setDetailName(value);
			} else if (key.equals("acnum_value")) {
				detail3.setDetailValue(value);
			} else if (key.equals("addrType")) {
				ac.setAddrType(value);
			} else if (key.equals("addr")) {
				payer.setAddr(value);
			} else if (key.equals("code")) {
				payer.setCode(value);
			} else if (key.equals("payer_name")) {
				payer.setName(value);
			} else if (key.equals("seq_num")) {
				payer.setSeqNum(value);
			} else if (key.equals("payer_type")) {
				payer.setType(value);
			} else if (key.equals("id")) {
				txn.setId(value);
			} else if (key.equals("note")) {
				txn.setNote(value);
			} else if (key.equals("refId")) {
				txn.setRefId(value);
			} else if (key.equals("refUrl")) {
				txn.setRefUrl(value);
			} else if (key.equals("payer_ts")) {
				txn.setTs(value);
			} else if (key.equals("txn_type")) {
				txn.setType(value);
			} else if (key.equals("txn_ts")) {
				txn.setTs(value);
			} else if (key.equals("msgId")) {
				head.setMsgId(value);
			} else if (key.equals("orgId")) {
				head.setOrgId(value);
			} else if (key.equals("head_ts")) {
				head.setTs(value);
			} else if (key.equals("ver")) {
				head.setVer(value);
			} else if (key.equals("ns2")) {
				reqOtp.setNs2(value);
				reqBalEnq.setNs2(value);
				reqSetCre.setNs2(value);
				reqListAccount.setNs2(value);
				reqHbt.setNs2(value);
			} else if (key.equals("ns3")) {
				reqBalEnq.setNs3(value);
				reqSetCre.setNs3(value);
				reqOtp.setNs3(value);
				reqListAccount.setNs3(value);
			} else if (key.equals("identity_id")) {
				identity.setIdentityId(value);
			} else if (key.equals("identity_type")) {
				identity.setIdentityType(value);
			} else if (key.equals("verified_name")) {
				identity.setVerifiedName(value);
			} else if (key.equals("verified_address")) {
				rating.setVerifiedAddress(value);
			} else if (key.equals("data_code")) {
				data.setCode(value);
				data1.setCode(value);
			} else if (key.equals("data_ki")) {
				data.setKi(value);
				data1.setKi(value);
			} else if (key.equals("data_value")) {
				data.setValue(value);
				data1.setValue(value);
			} else if (key.equals("cred_subtype")) {
				cred.setSubType(value);
				cred1.setSubType(value);
			} else if (key.equals("cred_type")) {
				cred.setType(value);
				cred1.setType(value);
			} else if (key.equals("link_type")) {
				link.setType(value);
			} else if (key.equals("link_value")) {
				link.setValue(value);
			} else if (key.equals("signature_xmlns")) {
				signature.setXmlns(value);
			} else if (key.equals("canonicalizationMethodAlgorithm")) {
				canonicalizationMethod.setAlgorithm(value);
			} else if (key.equals("signatureMethodAlgorithm")) {
				signatureMethod.setAlgorithm(value);
			} else if (key.equals("transformAlgorithm")) {
				transform.setAlgorithm(value);
			} else if (key.equals("digestMethodAlgorithm")) {
				digestMethod.setAlgorithm(value);
			} else if (key.equals("digestValue")) {
				digestValue.setValue(value);
			} else if (key.equals("URI")) {
				reference.setUri(value);
			} else if (key.equals("signatureValue")) {
				signatureValue.setValue(value);
			} else if (key.equals("modulus_value")) {
				modulus.setValue(value);
			} else if (key.equals("exponent_value")) {
				exponent.setValue(value);
			} else if (key.equals("hbtmsg_type")) {
				hbtMsg.setType(value);
			} else if (key.equals("hbtmsg_value")) {
				hbtMsg.setValue(value);
			}
		}

		ArrayList<Tag> tags = new ArrayList<Tag>();
		tags.add(tag1);
		tags.add(tag2);
		tags.add(tag3);
		tags.add(tag4);
		tags.add(tag5);
		tags.add(tag6);
		tags.add(tag7);
		tags.add(tag8);
		tags.add(tag9);

		device.setTags(tags);
		cred.setData(data);
		creds.setCred(cred);
		cred1.setData1(data1);
		newCred.setCred1(cred1);
		ArrayList<Detail> details = new ArrayList<Detail>();
		details.add(detail1);
		details.add(detail2);
		details.add(detail3);

		ac.setDetails(details);
		payer.setDevice(device);
		payer.setAc(ac);
		transforms.setTransform(transform);
		reference.setDigestMethod(digestMethod);
		reference.setDigestValue(digestValue);
		reference.setTransforms(transforms);

		signedInfo.setCanonicalizationMethod(canonicalizationMethod);
		signedInfo.setReference(reference);
		signedInfo.setSignatureMethod(signatureMethod);

		RSAKeyValue rsaKeyValue2 = new RSAKeyValue();
		rsaKeyValue.setExponent(exponent);
		rsaKeyValue.setModulus(modulus);

		keyValue.setRsaKeyValue(rsaKeyValue);
		keyInfo.setKeyValue(keyValue);

		signature.setSignedInfo(signedInfo);
		signature.setSignatureValue(signatureValue);
		signature.setKeyInfo(keyInfo);

		payer.setDevice(device);
		payer.setAc(ac);

		reqListAccount.setHead(head);
		reqListAccount.setTxn(txn);
		reqListAccount.setPayer(payer);
		reqListAccount.setLink(link);
		reqListAccount.setSignature(signature);

		payer.setInfo(info);
		payer.setCreds(creds);
		payer.setNewCred(newCred);
		// payer.setInfo(info);
		payer.setCreds(creds);
		payer.setNewCred(newCred);

		reqOtp.setHead(head);
		reqOtp.setTxn(txn);
		reqOtp.setPayer(payer);

		info.setIdentity(identity);
		info.setRating(rating);
		// payer.setInfo(info);

		reqBalEnq.setHead(head);
		reqBalEnq.setTxn(txn);
		reqBalEnq.setPayer(payer);

		reqSetCre.setHead(head);
		reqSetCre.setPayer(payer);
		reqSetCre.setTxn(txn);

		reqHbt.setHead(head);
		reqHbt.setTxn(txn);
		reqHbt.setHbtMsg(hbtMsg);
		reqHbt.setSignature(signature);

		try {

			if (api.equals("ReqOtp")) {
				xmlString = setJAXB(reqOtp, ReqOtp.class);
			} else if (api.equals("ReqBalEnq")) {
				xmlString = setJAXB(reqBalEnq, ReqBalEnq.class);
			} else if (api.equals("ReqSetCre")) {
				xmlString = setJAXB(reqSetCre, ReqSetCre.class);
			} else if (api.equals("ReqListAccount")) {
				xmlString = setJAXB(reqListAccount, ReqListAccount.class);
			} else if (api.equals("ReqHbt")) {
				xmlString = setJAXB(reqHbt, ReqHbt.class);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlString;
	}

	public static String setJAXB(Object api, Class cls) throws JAXBException {
		String xmlString;
		JAXBContext contxtObj = JAXBContext.newInstance(cls);
		Marshaller marshallerObj = contxtObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		marshallerObj.marshal(api, sw);
		xmlString = sw.toString();
		return xmlString;
	}

	public static String genrateRandomNumber() {
		String number = Integer.toString(ThreadLocalRandom.current().nextInt(11111111, 99999999));
		return number;

	}
	
	

}
