package spider.stock_details;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import spider.stock_details.domain.StockInfo;
import spider.stock_details.impl.StockRepositoryCustom;


public interface StockRepository extends MongoRepository<StockInfo, String>,StockRepositoryCustom {
	List<StockInfo> findByStockSymbol(String stockSymbol);
	
	@Query("{'stock.name': ?0}")
	List<StockInfo> findByName(String name);
	
}
