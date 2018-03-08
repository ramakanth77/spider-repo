package spider.stock_details.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

import spider.stock_details.domain.StockData;
import spider.stock_details.domain.StockInfo;

@Repository("StockDataRepo")
@ComponentScan(basePackages = "spider.spread_betting") 
public class StockDataRepoImpl implements StockDataRepoCustom {
	
	private static final Logger logger = Logger.getLogger(StockDataRepoImpl.class);
	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public int updateStockData(Integer stockId, Date date) {
	
		 Query query = new Query(Criteria.where("stockId").is(stockId));
	        Update update = new Update();
	        update.set("date", date);

	        WriteResult result = mongoTemplate.updateFirst(query, update, StockData.class);

	        if(result!=null)
	            return result.getN();
	        else
	            return 0;

	}
}
