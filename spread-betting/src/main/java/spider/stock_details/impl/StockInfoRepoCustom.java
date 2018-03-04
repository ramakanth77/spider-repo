package spider.stock_details.impl;

public interface StockInfoRepoCustom {
	int updateStockInfo(Integer stockId, String companyName);
	int updateStockInfo(Integer stockId, String securityId,Boolean listed);
}
