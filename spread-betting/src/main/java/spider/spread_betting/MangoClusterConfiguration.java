/**
 * 
 */
package spider.spread_betting;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

/**
 * @author ramakanth.reddy
 *
 */
@Configuration
public class MangoClusterConfiguration extends AbstractMongoConfiguration {

	MongoClientURI uri = new MongoClientURI("mongodb+srv://ramakanth77:reddy1234@spread-beatting-246kx.mongodb.net/test");
    public MangoClusterConfiguration() {
    	
	}
	
	@Override
	public String getDatabaseName() {
		return "test";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(uri);
	}
	

}
