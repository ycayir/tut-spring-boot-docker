package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yalcin Cayir
 */
@SpringBootApplication
@RestController
@RequestMapping("/")
public class Application {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String endpoints() {
        StringBuilder sb = new StringBuilder();
        sb.append("Available Endpoints:\n");
        sb.append("/hello\n");
        sb.append("/users/{userId}");

        return sb.toString();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping(value = "users/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable Integer userId) {
        Map<Integer, String> users = new HashMap<>();
        users.put(1, "Andy");
        users.put(2, "Mary");
        users.put(3, "Bob");

        return users.get(userId);
    }

    public static void main(String[] args) {

//        SpringApplication.run(Application.class, args);
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
}
