package spider.spread_betting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting",method=RequestMethod.GET,produces="application/json")
    public Object[] greeting(@RequestParam(value="name", defaultValue="World") String name) {
    		ArrayList<Greeting> list = new ArrayList<Greeting>();
    		Greeting g = new Greeting(counter.incrementAndGet(),
                    String.format(template, name));
    		list.add(g);
        return list.toArray();
    }
}