package spider.stock_details.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

import spider.spread_betting.Person;
import spider.stock_details.domain.StockData;
import spider.stock_details.domain.StockInfo;

@ComponentScan(basePackages = "spider.spread_betting") 
public class StockDataRepositoryImpl implements StockDataRepositoryCustom {
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public int updateStockData(StockInfo stock, Date date, Double price) {
		Query query = new Query(Criteria.where("stockSymbol").is(stock));
        Update update = new Update();
        update.set("date", date);
        update.set("price", price);
        WriteResult result = mongoTemplate.updateFirst(query, update, StockData.class);

        if(result!=null)
            return result.getN();
        else
            return 0;
	}

}
