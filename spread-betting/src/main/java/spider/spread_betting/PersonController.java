/**
 * 
 */
package spider.spread_betting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ramakanth.reddy
 *
 */
@RestController
@EnableMongoRepositories
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	@RequestMapping("/save")
    public String savePerson(String name,int age) {
        Person person =  new Person(name,age);
        repository.save(person);
        return "Save success";
    }
	@RequestMapping("/getPerson")
	public Person getPerson(String name) {
		return repository.findByName(name);
	}
	@RequestMapping("/getAll")
	public List<Person> getAllPersons(){
		return repository.findAll();
	}

}
