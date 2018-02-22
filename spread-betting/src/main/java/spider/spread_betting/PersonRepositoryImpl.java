package spider.spread_betting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

@ComponentScan(basePackages = "spider.spread_betting") 
public class PersonRepositoryImpl implements PersonRepositoryCustom {

	@Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int updatePerson(String name, Integer age) {

        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("age", age);

        WriteResult result = mongoTemplate.updateFirst(query, update, Person.class);

        if(result!=null)
            return result.getN();
        else
            return 0;

    }

	
}
