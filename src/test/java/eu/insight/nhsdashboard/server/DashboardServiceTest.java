package eu.insight.nhsdashboard.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import eu.insight.nhsdashboard.server.db.MongoUtils;




@RunWith(SpringJUnit4ClassRunner.class)  
@SpringApplicationConfiguration(classes = DashboardService.class)  
public class DashboardServiceTest {

	@Autowired
	private DashboardService dashboardService;
	
	@Ignore
	public void tesDI(){
		Assert.assertNotNull(dashboardService);
	}

	@Test
	public void getHeadersTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, InstantiationException{
		//dashboardService.getHeaderValues();
		
		BasicDBObject searchQuery=new BasicDBObject();
	    searchQuery.put("hash", "123");
	    DB db = MongoUtils.getMongoDB();
	    DBCursor cursor = db.getCollection("HeaderCacheTO").find(searchQuery);
	    if(cursor.hasNext()){
	    	DBObject dbObj = cursor.next();
	    	List result = new Gson().fromJson(dbObj.get("value").toString(),List.class);
	    }
	}


}
