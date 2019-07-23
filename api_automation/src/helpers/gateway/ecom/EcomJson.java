package helpers.gateway.ecom;

import helpers.MyJson;
import java.security.NoSuchAlgorithmException;
import Util.Encrypt;

public class EcomJson extends MyJson{
		private String txnRefNO;
		private String txnDate;
		private String amount;
		private String refundRefNo;
		private String txnId;
		
		public String getTxnRefNO() {
			 return txnRefNO;
		}
		public void setTxnRefNO(String txnRefNO) {
			 this.txnRefNO = txnRefNO;
		}
		public String getTxnDate() {
			return txnDate;
		}
		public void setTxnDate(String txnDate) {
			this.txnDate = txnDate;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getRefundRefNo() {
			return refundRefNo;
		}
		public void setRefundRefNo(String refundRefNo) {
			this.refundRefNo = refundRefNo;
		}
		public String getTxnId() {
			 return txnId;
		}
		public void setTxnId(String txnId) {
			 this.txnId = txnId;
		}
}
