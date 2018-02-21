package spider.spread_betting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner init(PersonRepository domainRepository) {

        return args -> {

            Person obj = domainRepository.findOne(34);
            System.out.println(obj);

            Person obj2 = domainRepository.findByName("Joe");
            System.out.println(obj2);

            int n = domainRepository.updatePerson("Joe", 50);
            System.out.println("Number of records updated : " + n);

        };

    }
}
