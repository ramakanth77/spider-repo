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
@Document(collection = "bscstockdata")
@TypeAlias("bscstock")
public class StockData extends AbstractDocument{

	
	
	private Integer stockId;
	
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	@Override
	public String toString() {
		return "StockData [date=" + date + ", previousClose=" + previousClose + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", volume=" + volume + "]";
	}
	private Date date;
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setPreviousClose(Double previousClose) {
		this.previousClose = previousClose;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	private Double previousClose;
	private Double open;
	private Double high;
	private Double low;
	
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
