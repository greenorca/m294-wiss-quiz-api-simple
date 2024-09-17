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

import wiss.m294.wissquizapi.model.Category;

@CrossOrigin
@RestController
public class CategoryController {

	Logger logger = LoggerFactory.getLogger(CategoryController.class);

	CategoryService service = CategoryService.getInstance();

	@GetMapping("/categories")
	public List<Category> all() {
		logger.info("Received GET for categories");
		return service.getAll();
	}

	@PostMapping("/categories")
	public Category newcategory(@RequestBody Category newcategory) {
		logger.info("Received POST for category: " + newcategory.getName());
		return service.add(newcategory);
	}

	@DeleteMapping("/categories/{id}")
	public void deletecategory(@PathVariable int id) {
		logger.info("Received DELETE for category: " + id);
		service.deleteById(id);
	}
}
