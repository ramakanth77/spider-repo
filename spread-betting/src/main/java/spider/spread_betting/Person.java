package spider.spread_betting;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Person {
	  @Id
	  private String id;
	  
	  @Indexed(unique = true)
	  private String name;
	  private int age;
	   
	  public Person(String name, int age) {
	    this.name = name;
	    this.age = age;
	  }
	  
	  public String getId() {
	    return id;
	  }
	  public String getName() {
	    return name;
	  }
	  public int getAge() {
	    return age;
	  }
	  
	  @Override
	  public String toString() {
	    return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	  }
	  
	}
