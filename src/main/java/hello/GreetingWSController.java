package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Greeting Web Service Controller
 *
 * Anothr example of a controller that wil handle the Web Service work seperately.
 *
 * PHP version 5
 *
 *
 * @author     Anthony Smith <antland01@gmail.com>
 */

@RestController
public class GreetingWSController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    
/*
 * Greeting WS Method
 *
 * Like greeting but returns the result as JSON. 
 */
    @RequestMapping("/greetingws")
    public Greeting greetingws(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}