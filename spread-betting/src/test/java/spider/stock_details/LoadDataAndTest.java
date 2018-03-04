package spider.stock_details;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spider.stock_details.domain.StockInfo;

@EnableMongoRepositories
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ComponentScan

public class LoadDataAndTest {
	@Autowired
	private StockInfoRepo stockRepo;
	
	private static final String ENDPOINT="stocks/get";
	
	@Test
	public void givenRequestForStocks_whenSizeIsTwo_expectNumberOfElementsTwo() {
	    given().params("page", "0", "size", "2").get(ENDPOINT)
	      .then()
	      .assertThat().body("numberOfElements", equalTo(2));
	}
	
	@Test
	public void getStockInfo() throws Exception {
		assertThat(true,is(true));
		/*List<StockInfo> info = stockRepo.findAll();
		System.out.println("------> List length is :"+info.size());
		info.forEach(s->System.out.println(s.getStockId()+s.getCompanyName()));*/
		
	}
	//@Test
	public void deleteAllRecords() throws Exception {
		stockRepo.deleteAll();
	}
	//@Test
	public void getFile() throws Exception {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("StockInfo.csv").getFile());

		stockRepo.deleteAll();
		
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				System.out.println(line);
				StockInfo info = new StockInfo(Integer.parseInt(line.split(",")[0]),line.split(",")[1]);
				System.out.println(info.getStockId()+" "+info.getCompanyName());
				stockRepo.save(info);
				System.out.println("-------------SAVED-------------");
			}
			scanner.close();
			System.out.println("closed");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

}
