package helpers.gateway.phonePE;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import helpers.GlobalHelper;


public class Data extends GlobalHelper {
	
	public void allowMerchantForSBA(String merchantId, String customerType)
			throws ClassNotFoundException, IOException, SQLException {
		String query = String.format(
				"update MERCHANT_TOKEN_DETAILS set TRANSACTIONALLOWED ='%s' where MERCHANTID = '%s'", customerType,
				merchantId);
		// String query = "update MERCHANT_TOKEN_DETAILS set TRANSACTIONALLOWED =" + "'"
		// + customerType + "'" + " where MERCHANTID = " + "'" + merchantId+ "'";
		updateDataInOracleDb(query, "GATEWAYAMCARE");
	}

	public void updateDelFlagVolt(String customerId, String flag) throws IOException {
		String query = String.format("update VOLT_TXN_TOKEN set DEL_FLAG = %s where CUSTOMER_ID = '%s'",
				Integer.parseInt(flag), customerId);
		updateDataInOracleDb(query, "VOLTSIT4");
	}
	
	public void insertVoltTxnToken(String customerId, String expiry, String merchantId, String delFlag) throws IOException {
		String query = String.format("insert into VOLT_TXN_TOKEN values ('%s', '%s', TO_DATE('%s', 'YYYY-MM-DD HH:MI:SS'), 'ALL', 1, 100, 50, 'MER', '%s', %s, TO_DATE('2018-09-17 11:27:48', 'YYYY-MM-DD HH:MI:SS'), TO_DATE('2018-09-17 11:07:38', 'YYYY-MM-DD HH:MI:SS'))", generateRandomCustAuth(), customerId, expiry, merchantId, delFlag);
		System.out.println(query);
		updateDataInOracleDb(query, "VOLTSIT4");
	}

	public void updateTokenExpiryData(String customerId, String tokenExpiry) throws IOException {
		String query = String.format(
				"update VOLT_TXN_TOKEN set EXPIRY_DATE = TO_DATE('%s', 'YYYY-MM-DD HH:MI:SS'), DEL_FLAG = 0 where CUSTOMER_ID = '%s'",
				tokenExpiry, customerId);
		updateDataInOracleDb(query, "VOLTSIT4");
	}

	public void updateUsedAndMaxTokenCount(String usedTokenCount, String maxTokenCount, String customerId)
			throws IOException {
		String query = String.format(
				"update VOLT_TXN_TOKEN set USED_TOKEN_COUNT = %s, MAX_TOKEN_COUNT = %s, DEL_FLAG = 0 where CUSTOMER_ID = '%s'",
				Integer.parseInt(usedTokenCount), Integer.parseInt(maxTokenCount), customerId);
		updateDataInOracleDb(query, "VOLTSIT4");
	}

	public String getBalance(String customerId) throws ClassNotFoundException, SQLException, IOException {
		String query = String.format(
				"select ch_acct_mast.BAL_AVAILABLE from fcrhost.ch_acct_mast where COD_CUST = (select COD_CUST_ID from fcrhost.CH_X_MOBILE_ACCT_XREF where COD_CUST_NATL_ID = '%s' and COD_CUST_SEGMENT = 'CUS' )",
				customerId);
		return getStringValueFromDb(query, "CBSSIT");
	}

	public String generateRandomCustAuth() {
		return "91" + Integer.toString(ThreadLocalRandom.current().nextInt(100000000, 999999999))
				+ Integer.toString(ThreadLocalRandom.current().nextInt(10, 99));
	}

}
