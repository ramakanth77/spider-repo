package spider.stock_details;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;



import spider.stock_details.domain.StockInfo;
import spider.stock_details.impl.StockInfoRepoCustom;

@Repository
public interface StockInfoRepo extends MongoRepository<StockInfo, Integer>,StockInfoRepoCustom{
	public StockInfo findByStockId(Integer stockId);
    public List<StockInfo> findByListed(Boolean isListed);
    public StockInfo findByCompanyName(String companyName);
    
   
    
  
	
}
