package spider.spread_betting;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer>,PersonRepositoryCustom {

    public Person findByName(String name);
    public List<Person> findByAge(int age);

}
