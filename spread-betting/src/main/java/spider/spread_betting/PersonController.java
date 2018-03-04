/**
 * 
 */
package spider.spread_betting;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ramakanth.reddy
 *
 */
@RestController
@EnableMongoRepositories
public class PersonController {
	
	final static Logger logger = Logger.getLogger(PersonController.class);
	
	
	@Autowired
	private PersonRepository repository;
	@RequestMapping("/save")
    public String savePerson(String name,Integer age) {
		
        Person person =  new Person(name,age);
        Person saved=repository.save(person);
        if(saved!=null)
        	return "Saved";
        else
        	return "Fail";
    }
	@RequestMapping("/getPerson")
	public Person getPerson(String name) {
		return repository.findByName(name);
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET,produces="application/json")
	public Object[] getAllPersons(){
		return repository.findAll().toArray();
	}

	@RequestMapping("/delete")
	public void deletePerson(String name) {
		repository.delete(repository.findByName(name));
	}
}
