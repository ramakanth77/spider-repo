/**
 * 
 */
package spider.spread_betting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author ramakanth.reddy
 *
 */

//@WebMvcTest(PersonController.class)
@EnableMongoRepositories
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonTest {

	
	
	@Autowired
	private PersonRepository repository;
	//@Autowired
    private MockMvc mockMvc;
	
	
	public void deletePersonTest() throws Exception{
        mockMvc.perform(post("/delete")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content("{ 'name' : 'null'}"))
        		.andDo(print())
        		.andExpect(status().is2xxSuccessful());
		
	}
	@Test
	public void getAllPersons() {
		List<Person> persons = repository.findAll();
		persons.forEach(u->System.out.println("hello "+u));
	}
	
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/getAll")).andDo(print()).andExpect(status().isOk());
    }
	
	
	public  void savePersonOperationWithJSON() throws Exception {
        mockMvc.perform(post("/save")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content("{\"name\":\"Amrutha\",\"age\":42}"))
        		.andDo(print())
        		.andExpect(status().is2xxSuccessful());

	}

			
    
	
}
