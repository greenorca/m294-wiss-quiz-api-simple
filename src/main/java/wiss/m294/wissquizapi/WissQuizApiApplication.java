package wiss.m294.wissquizapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WissQuizApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WissQuizApiApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		System.out.println("Received GET for /");
		return "Hello World! Try using GET, POST und DELETE on /questions";
	}

}
