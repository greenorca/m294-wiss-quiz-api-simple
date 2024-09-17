package wiss.m294.wissquizapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import wiss.m294.wissquizapi.model.Category;

/**
 * This class exposes methods for adding, removing and loading {@link Category}
 * objects. {@link Category} objects are stored in a HashMap with an integer ID
 * as key, which is also available in the {@link Category} objects.
 *
 * @author Patrick Meier
 *
 */
public class CategoryService {

	private int idCounter;
	private HashMap<Integer, Category> categories;

	private static CategoryService singleton;

	public CategoryService() {
		categories = new HashMap<>();
		categories.put(1, new Category(1, "Mathe"));

		categories.put(2, new Category(2, "Deutsch"));

		categories.put(3, new Category(3, "Quantentheorie"));

		idCounter = 4;
	}

	/**
	 * This method collects all values of the HashMap and returns them as a List of
	 * Category objects.
	 *
	 * @return List of Category objects
	 */
	public List<Category> getAll() {
		return categories.values().stream().toList();
	}

	/**
	 * This method sets the currently stored id-index to the provided newCategory
	 * object, adds newCategory to the HashMap, updates the id-index and finally
	 * returns the updated newCategory object.
	 *
	 * @param newCategory {@link Category} object to be added to the HashMap
	 * @return {@link Category} object with an update {@link Category#id} value
	 */
	public Category add(Category newCategory) {
		newCategory.setId(idCounter);
		categories.put(idCounter, newCategory);
		idCounter++;
		return newCategory;
	}

	/**
	 * Removes a {@link Category} object from the HashMap via key value.
	 *
	 * @param id key value used to remove the {@link Category} object from the
	 *           HashMap.
	 */
	public void deleteById(int id) {
		categories.remove(id);
	}

	/**
	 * Returns a singleton instance of the Category Service. Should be used in a server
	 * environment to ensure proper handling of HashMap data.
	 *
	 * @return Singleton {@link QuizService} object
	 */
	public static CategoryService getInstance() {
		if (singleton == null) {
			singleton = new CategoryService();
		}

		return singleton;
	}
}
