/**
 * 
 */
package spider.spread_betting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author ramakanth.reddy
 *
 */
@EnableMongoRepositories
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonTest {

	
	
	@Autowired
	private PersonRepository repository;
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }
	
	@Test
	public void savePerson() throws Exception{
		repository.insert(new Person("Sneha", 26));
	}
	@Test
	public void getPerson() throws Exception{
		String name = "Joe";
		Person found = repository.findByName(name);
		
		assertThat(found.getAge())
	      .isEqualTo(34);
	}
		
    
	
}
