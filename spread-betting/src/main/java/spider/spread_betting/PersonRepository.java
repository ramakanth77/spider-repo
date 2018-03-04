package spider.spread_betting;

import java.util.List;
import java.util.stream.Stream;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends MongoRepository<Person, Integer>,PersonRepositoryCustom {

    public Person findByName(String name);
    public List<Person> findByAge(Integer age);

}
