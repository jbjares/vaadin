package eu.insight.nhsdashboard.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
//@UIScope
public class DashboardService {
	
	
	public List<String> getHeaderValues(){
		List<String> headers = new ArrayList<String>();
		MongoTemplate mongoTemplate = SpringBeanFactory.create(org.springframework.data.mongodb.core.MongoTemplate.class);
		final BasicQuery query = new BasicQuery("\"Headercache\" : {\"R_OBJ\" : true, \"value\" : { \"hash\" : { \"hash\" : \"cf23df2207d99a74fbe169e3eba035e633b65d94\"}");
		String result = mongoTemplate.findOne(query, String.class, "HeaderCacheTO");
		System.out.println(result);
//		mongoOperations.execute("jvmInfo", new CollectionCallback<String>() {
//
//			@Override
//			public String doInCollection(DBCollection collection)throws MongoException, DataAccessException {
//			    DBCursor cursor = collection.find(query);
//			    return cursor.next().toString();			
//			}
//
//		});
		
   	 	return headers;
	}


}



