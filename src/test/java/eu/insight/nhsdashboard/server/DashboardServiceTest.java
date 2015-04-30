package eu.insight.nhsdashboard.server;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;




@RunWith(SpringJUnit4ClassRunner.class)  
@SpringApplicationConfiguration(classes = DashboardService.class)  
public class DashboardServiceTest {

	      
	
	@Test
	public void getHeadersTest(){
	     String textUri = "mongodb://jbjares:multivision@ds061371.mongolab.com:61371/multivision_jbjares";
	     MongoClientURI uri = new MongoClientURI(textUri);
	     MongoClient m = new MongoClient(uri);

		
		List<String> headers = new ArrayList<String>();
		MongoTemplate mongoTemplate = SpringBeanFactory.create(org.springframework.data.mongodb.core.MongoTemplate.class);
		BasicDBObject searchQuery=new BasicDBObject();
	    searchQuery.put("_id", new ObjectId("55418c1510fc35b4fa9ced38"));
	    DB db = m.getDB("multivision_jbjares");
	    DBCursor cursor = db.getCollection("HeaderCacheTO").find(searchQuery);
	    if( cursor.hasNext() ){
	    	DBObject obj = cursor.next();
	    	System.out.println(obj.toMap().toString());
	    }
	}

}
