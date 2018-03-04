package spider.stock_details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spider.stock_details.domain.StockInfo;

@RestController
@EnableMongoRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages = "spider.spread_betting") 
public class StocksController {

	
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
}
