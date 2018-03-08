package spider.stock_details.impl;

import spider.stock_details.domain.StockData;
import spider.stock_details.domain.StockInfo;

public interface StockInfoRepoCustom {
	int updateStockInfo(Integer stockId, String companyName);
	int updateStockInfo(Integer stockId, String securityId,Boolean listed);
	
}
