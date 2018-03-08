/**
 * 
 */
package spider.stock_details.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import spider.stock_details.AbstractDocument;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;

/**
 * @author ramakanth.reddy
 *
 */
@Document(collection = "stockInfoDetails")
@TypeAlias("stock")
public class StockInfo extends AbstractDocument implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Indexed(unique = true)
	@Field("stockId")
	private Integer stockId;
	
	
	private String securityId;
	
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	
	private String companyName;
	
	private boolean listed;

	public StockInfo() {
		
	}
	
	@PersistenceConstructor
	public StockInfo(Integer stockId,String companyName) {
		this.stockId = stockId;
		this.companyName = companyName;
	}
	
	public Integer getStockId() {
		return stockId;
	}
	
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setListed(boolean listed) {
		this.listed = listed;
	}
	public String getCompanyName() {
		return companyName;
	}
	public boolean isListed() {
		return listed;
	}
	@Override
	public String toString() {
		return "StockInfo [stockId=" + stockId + ", securityId=" + securityId + ", companyName=" + companyName
				+ ", listed=" + listed + "]";
	}

	
	
	
}
