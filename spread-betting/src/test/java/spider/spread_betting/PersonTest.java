/**
 * 
 */
package spider.spread_betting;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author ramakanth.reddy
 *
 */
public class PersonTest {

	@Autowired
    private MockMvc mockMvc;
	
	
	@Autowired
	private PersonRepository repository;
	
	@Test
	public void getPerson() throws Exception{
		String name = "Joe";
		Person found = repository.findByName(name);
		
		assertThat(found.getName())
	      .isEqualTo(name);
	}
		
    
	public void listPersons() throws Exception{
    	mockMvc.perform(get("http://localhost:8080/getAll")).andExpect(status().isOk())
         .andExpect(view().name("listEmployees"));
	}
	
	public void insertPerson() throws Exception{
		this.mockMvc.perform(get("/getPerson")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.content").value("Hello, World!"));
	}
}
