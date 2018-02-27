package spider.stock_details.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

import spider.spread_betting.Person;

@ComponentScan(basePackages = "spider.spread_betting") 
public class StockRepositoryImpl implements StockRepositoryCustom{

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public int updateStock(String stockSymbol, String name) {
		 Query query = new Query(Criteria.where("stockSymbol").is(stockSymbol));
	        Update update = new Update();
	        update.set("name", name);

	        WriteResult result = mongoTemplate.updateFirst(query, update, Person.class);

	        if(result!=null)
	            return result.getN();
	        else
	            return 0;

	}

}
