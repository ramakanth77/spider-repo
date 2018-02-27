/**
 * 
 */
package spider.stock_details.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import spider.stock_details.AbstractDocument;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;

/**
 * @author ramakanth.reddy
 *
 */
@Document(collection = "stocks")
@TypeAlias("stock")
public class StockInfo extends AbstractDocument implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Indexed(unique = true)
	@Field("stockSymbol")
	private String stockSymbol;
	
	private String name;

	@PersistenceConstructor
	public StockInfo(String stockSymbol,String name) {
		this.stockSymbol = stockSymbol;
		this.name = name;
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

	
	public String getStockSymbol() {
		return stockSymbol;
	}

	public String getName() {
		return name;
	}
	
}
