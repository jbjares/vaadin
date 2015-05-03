package eu.insight.nhsdashboard.server;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import eu.insight.nhsdashboard.server.db.MongoUtils;

@SpringComponent
@UIScope
public class DashboardService {

	// @Autowired
	// private MongoOperations mongoOperations;

	@SuppressWarnings("unchecked")
	public List<String> getHeaderValues(String hash) {
		List<String> headers = new ArrayList<String>();

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("hash", hash);
		DB db = MongoUtils.getMongoDB();
		DBCursor cursor = db.getCollection("HeaderCacheTO").find(searchQuery);
		if (cursor.hasNext()) {
			DBObject dbObj = cursor.next();
			headers = new Gson().fromJson(dbObj.get("value").toString(),List.class);
			return headers;
		}
		return headers;
	}

	//
	// public void createHashCollection(String hash){
	// DB db = MongoUtils.getMongoDB();
	// String collectionName = "HeaderCacheTO_"+hash;
	// if(db.collectionExists(collectionName)){
	// return;
	// }
	// DBObject options = BasicDBObjectBuilder.start().add("capped",
	// true).add("size", 2000000000l).get();
	// db.createCollection(collectionName,options);
	// }

}
