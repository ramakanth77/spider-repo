package spider.stock_details;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import spider.stock_details.domain.StockData;
import spider.stock_details.domain.StockInfo;
import spider.stock_details.impl.StockDataRepositoryCustom;


public interface StockDataRepository extends MongoRepository<StockData, StockInfo>,
						StockDataRepositoryCustom {
	List<StockData> findByStockSymbol(StockInfo stock);
	@Query("{'stock.name': ?0}")
	List<StockInfo> findByDate(Date date);

}
