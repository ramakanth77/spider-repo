package spider.spread_betting;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Integer> {

    public Person findByName(String name);
    public List<Person> findByAge(int age);

}
