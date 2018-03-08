package spider.stock_details;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import spider.stock_details.domain.StockData;
import spider.stock_details.impl.StockDataRepoCustom;

@Repository
public interface StockDataRepo extends MongoRepository<StockData, Integer>,StockDataRepoCustom {
	public List<StockData> findByStockId(Integer stockId);
    public List<StockData> findByDate(Date date);
}
