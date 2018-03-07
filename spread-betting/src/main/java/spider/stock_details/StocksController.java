package spider.stock_details;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spider.stock_details.domain.StockData;
import spider.stock_details.domain.StockInfo;

@RestController
@EnableMongoRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages = "spider.spread_betting") 
public class StocksController {

	public static Logger logger = Logger.getLogger(StocksController.class);
	
	@Autowired
	private StockInfoRepo stockRepo;
	
	@RequestMapping(
      value = "/stocks/get", 
      params = { "page", "size" }, 
      method = RequestMethod.GET
    )
	public Page<StockInfo> findPaginated(
      @RequestParam("page") int page, @RequestParam("size") int size) {
		System.out.println(page+" page size "+size);
		
        Page<StockInfo> resultPage = stockRepo.findAll(new PageRequest(page,size));
        if (page > resultPage.getTotalPages()) {
            throw new spider.stock_details.domain.MyResourceNotFoundException();
        }
 
        return resultPage;
    }
	
	@RequestMapping(value="/stocks/top10",method=RequestMethod.GET)
	public Page<StockInfo> getOnlyFiveStocks(){
		Pageable topTen = new PageRequest(0, 10);
		Page<StockInfo> result = stockRepo.findAll(topTen);
		return result;
	}
	
	@RequestMapping(value = "/stocks/newdata", method = RequestMethod.POST,consumes =  MediaType.APPLICATION_JSON_VALUE)	
	public  @ResponseBody String saveUserRestful(@RequestBody CommandBean commandBean)   {		
		System.out.println("---->stockId is :"+commandBean.getStockId()+" data is "+commandBean.getStockData());
		//
		// Code processing the input parameters
		//	
	 	String response = "{\"message\":\"Post With ngResource\"}" ;
		return response;
	}

}
