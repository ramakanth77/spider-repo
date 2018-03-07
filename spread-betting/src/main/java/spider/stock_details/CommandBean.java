package spider.stock_details;

import spider.stock_details.domain.StockData;

public class CommandBean {
	String stockId;
	StockData stockData;
	public String getStockId() {
		return stockId;
	}
	public StockData getStockData() {
		return stockData;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public void setStockData(StockData stockData) {
		this.stockData = stockData;
	}
	
}
