package eu.insight.nhsdashboard.server.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoUtils {

	private static MongoClient client;
	
	public static DB getMongoDB(){
		if(client==null){
			//TODO Adjust the code below to remove static resource into texturi
			String textUri = "mongodb://jbjares:multivision@ds061371.mongolab.com:61371/multivision_jbjares";
			MongoClientURI uri = new MongoClientURI(textUri);
			MongoClient m = new MongoClient(uri);
			return m.getDB("multivision_jbjares");
		}
		return client.getDB("multivision_jbjares");
	}
}
