package spider.stock_details.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

import spider.stock_details.domain.StockInfo;

@Repository("StockInfoRepo")
@ComponentScan(basePackages = "spider.spread_betting") 
public class StockInfoRepoImpl implements StockInfoRepoCustom{
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public int updateStockInfo(Integer stockId, String companyName) {
		 Query query = new Query(Criteria.where("stockId").is(stockId));
	        Update update = new Update();
	        update.set("companyName", companyName);

	        WriteResult result = mongoTemplate.updateFirst(query, update, StockInfo.class);

	        if(result!=null)
	            return result.getN();
	        else
	            return 0;

	}
	
	@Override
	public int updateStockInfo(Integer stockId, String securityId,Boolean listed) {
		Query query = new Query(Criteria.where("stockId").is(stockId));
		Update update = new Update();
		update.set("securityId", securityId);
		update.set("listed", listed);
		
		WriteResult result = mongoTemplate.updateFirst(query, update, StockInfo.class);
		
		if(result != null)
			return result.getN();
		else
			return 0;
	}
}
