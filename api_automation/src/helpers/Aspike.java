package helpers;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.WritePolicy;

public class Aspike {

	public String url = "10.56.110.174";
	public AerospikeClient client;
	public Key key;

	public Aspike(String nameSpace, String setName, String pk) {
		client = new AerospikeClient(url, 3000);
		key = new Key(nameSpace, setName, pk);
	}

	public void deleteRecord() {
		System.out.println("Deleting Record....");
		WritePolicy policy = new WritePolicy();
		client.delete(policy, key);
		client.close();
	}

	public Record getRecord() {
		System.out.println("Fetching Record...");
		Record rec = client.get(null, key);
		client.close();
		return rec;
	}

	public void insertRecord(Bin... bin) {
		System.out.println("Inserting Record...");
		client.put(null, key, bin);
		client.close();
	}
}
