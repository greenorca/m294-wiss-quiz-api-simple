package wiss.m294.wissquizapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import wiss.m294.wissquizapi.model.Question;

@CrossOrigin
@RestController
public class QuizController {

	Logger logger = LoggerFactory.getLogger(QuizController.class);

	QuizService service = QuizService.getInstance();

	@GetMapping("/questions")
	public List<Question> all() {
		logger.info("Received GET for questions");
		return service.getAll();
	}

	@PostMapping("/questions")
	public Question newQuestion(@RequestBody Question newQuestion) {
		logger.info("Received POST for question: " + newQuestion.getQuestion());
		return service.add(newQuestion);
	}

	@DeleteMapping("/questions/{id}")
	public void deleteQuestion(@PathVariable int id) {
		logger.info("Received DELETE for question: " + id);
		service.deleteById(id);
	}
}
