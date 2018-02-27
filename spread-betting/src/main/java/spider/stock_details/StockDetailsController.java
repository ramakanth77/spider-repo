package spider.stock_details;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spider.spread_betting.Person;
import spider.spread_betting.PersonController;
import spider.spread_betting.PersonRepository;
import spider.stock_details.domain.StockInfo;
import spider.stock_details.impl.StockDataRepositoryCustom;

 /**
  * 
  * @author ramakanth.reddy
  *
  */


@RestController
@EnableMongoRepositories
public class StockDetailsController {
final static Logger logger = Logger.getLogger(StockDetailsController.class);
	
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private StockDataRepository dataRepo;
	
	
	@RequestMapping("/addNew")
    public String addNewStock(String symbol,String name) {
		
        StockInfo stock =  new StockInfo(symbol,name);
        StockInfo saved=stockRepo.save(stock);
        if(saved!=null)
        	return "Saved";
        else
        	return "Fail";
    }
	
	@RequestMapping("/getStock")
	public List<StockInfo> getPerson(String name) {
		return stockRepo.findByName(name);
	}
	@RequestMapping("/getAll")
	public List<StockInfo> getAllStockInfo(){
		return stockRepo.findAll();
	}

	@RequestMapping("/delete")
	public void deletePerson(String name) {
		stockRepo.delete(stockRepo.findByName(name));
	}
}
