package spider.spread_betting;


import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoApp {

	final static Logger logger = Logger.getLogger(MongoApp.class);

  public static void main(String[] args) throws Exception {

	 MongoClientURI uri = new MongoClientURI("mongodb+srv://ramakanth77:reddy1234@spread-beatting-246kx.mongodb.net/test");

	
	MongoClient mongoClient = new MongoClient(uri);
    @SuppressWarnings("deprecation")
    MongoOperations mongoOps = new MongoTemplate(mongoClient, "test");

    //mongoOps.insert(new Person("Joe", 34));

   logger.info(mongoOps.findOne(new Query(Criteria.where("name").is("Ramakanth")), Person.class));

    //mongoOps.dropCollection("person");
  }
}
