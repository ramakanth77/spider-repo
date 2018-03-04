/**
 * 
 */
package spider.spread_betting;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		Page<Person> persons = repository.findAll(new PageRequest(0,3));
		assertThat(persons.isFirst(),is(true));
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
