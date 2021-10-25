package nl.abnamro.recipes.data;

import nl.abnamro.recipes.model.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecipeRepository extends ReactiveMongoRepository<Recipe, String> {
}
