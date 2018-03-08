package spider.stock_details;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.CoreMatchers.is;

import spider.stock_details.domain.StockData;
import spider.stock_details.domain.StockInfo;

@EnableMongoRepositories
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ComponentScan
public class StckInfoDataTest {
	@Autowired
	private StockDataRepo dataRepo;
	
	@Test
	public void TestAndCheckStockData() throws Exception{
		dataRepo.deleteAll();
		//StockInfo stock = stockRepo.findByStockId(500002);
		//System.out.println(stock);
		
		assertThat(dataRepo.findAll().size(),is(0));
	}
}
