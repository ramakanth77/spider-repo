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
@Document(collection = "stockdata")
@TypeAlias("data")
public class StockData extends AbstractDocument{

	@Indexed(name="stockIndex",unique=true)
	@DBRef
	private StockInfo stockSymbol;
	
	private Date date;
	private Double price;
	private Long volume;
	public StockInfo getStockSymbol() {
		return stockSymbol;
	}
	public Date getDate() {
		return date;
	}
	public Double getPrice() {
		return price;
	}
	public Long getVolume() {
		return volume;
	}
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
    	return jsonString;
	}
}
