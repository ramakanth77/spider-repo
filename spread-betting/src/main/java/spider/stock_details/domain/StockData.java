package spider.stock_details.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import spider.stock_details.AbstractDocument;
@Document(collection = "stockdailydata")
@TypeAlias("stockdata")
public class StockData extends AbstractDocument{

	@Indexed(name="stockInfo",unique=true)
	@DBRef
	private StockInfo stockInfo;
	
	private Date date;
	private Double previousClose;
	private Double open;
	private Double high;
	private Double low;
	
	public StockInfo getStockInfo() {
		return stockInfo;
	}
	public Double getPreviousClose() {
		return previousClose;
	}
	public Double getOpen() {
		return open;
	}
	public Double getHigh() {
		return high;
	}
	public Double getLow() {
		return low;
	}
	private Long volume;
	
	public Date getDate() {
		return date;
	}
	
	public Long getVolume() {
		return volume;
	}
	
}
