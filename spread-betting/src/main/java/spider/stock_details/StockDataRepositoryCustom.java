package spider.stock_details.impl;

import java.util.Date;

import spider.stock_details.domain.StockInfo;

public interface StockDataRepositoryCustom {
	int updateStockData(StockInfo stock, Date date,Double price);
}
