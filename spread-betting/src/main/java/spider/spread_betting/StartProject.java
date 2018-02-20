package spider.spread_betting;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class StartProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		MongoClientURI uri = new MongoClientURI(
				   "mongodb://ramakanth77:reddy1234@cluster0.mongodb.net/");
		
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
			
		
	}

}
