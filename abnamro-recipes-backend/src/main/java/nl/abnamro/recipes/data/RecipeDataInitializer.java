package nl.abnamro.recipes.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import nl.abnamro.recipes.model.Recipe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class RecipeDataInitializer implements CommandLineRunner {

    private final RecipeRepository repository;

    @SneakyThrows
    @Override
    public void run(String... args) {
        List<Recipe> recipes = new ArrayList<>();
        List<String> ingredients = List.of(
                "1 onion",
                "1 carrot",
                "3 chestnut mushrooms",
                "1 lb minced beef",
                "2 cloves garlic",
                "1/2 cup red wine",
                "3 tbsp tomato puree",
                "1 beef stock cube",
                "1/2 tbs salt",
                "1/2 tbs black pepper",
                "10 1/2 dried spaghetti or fresh pasta"
        );

        String instructions =
                "Heat the oil in a frying pan over a medium-high heat. Add the onion and cook for 5 minutes, stirring often, until the onion softens.\n"
                        + "Add the garlic and cook for a further minute.\n"
                        + "Add the carrot and mushrooms and cook for a further 2-3 minutes.\n"
                        + "Add the minced beef and cook for 5-6 minutes, until browned. Stir often, breaking up any large chunks of meat with a spatula.\n"
                        + "Add the wine. Bring to the boil and let it bubble for 2-3 minutes, until reduced by three quarters.\n"
                        + "Add the tomato puree, beef stock cube, tinned tomatoes, salt and pepper. Stir and bring to the boil. Turn down the heat and simmer for 15 -20 minutes until thickened.\n"
                        + "Meanwhile, boiled a large pan of salted water. Add the spaghetti and cook for 10-12 minutes until al dente.\n"
                        + "Drain the spaghetti and divide between 6 bowls.\n"
                        + "Spoon the bolognese on top of the spaghetti.\n";

        Recipe recipe = Recipe.builder()
                .id(UUID.randomUUID().toString())
                .name("Spaghetti Bolognese")
                .created(LocalDateTime.now())
                .vegan(false)
                .servings(4)
                .ingredients(ingredients)
                .instructions(instructions)
                .build();

        recipes.add(recipe);

       List<String> ingredients1 = List.of(
                "1 Lemons",
                "1 Water",
                "3 sugar"
                );
        String instructions1 = "\"Slice the lemons in half.\"\n" +
                "\"Squeeze lemons by hand or with a lemon squeezer into pitcher.\"\n" +
                "\"Remove seeds from pitcher.\"\n" +
                "\"Add water.\"\n" +
                "\"Add sugar and stir thoroughly until sugar is dissolved.\"\n" +
                "\"Serve in chilled glasses with ice.\"";
        recipe = Recipe.builder()
                .id(UUID.randomUUID().toString())
                .name("Lemonde")
                .created(LocalDateTime.now())
                .vegan(false)
                .servings(10)
                .ingredients(ingredients1)
                .instructions(instructions1)
                .build();

        recipes.add(recipe);

        List<String> ingredients2 = List.of(
                "1 Cheese",
                "1 Bread",
                "3 Pepper",
                "4 Butter"
                );
        String instructions2 = "\"Melt butter in gtill pan over medium heat until bubbling.\"\n" +
                "\"Place one slice of bread in butter.\"\n" +
                "\"Add cheese and last slice of bread.\"\n" +
                "\"Grill for 4 minutes.\"\n" +
                "\"Flip sandwich over and press down with spatula.\"\n" +
                "\"Grill 3 more minutes.\"\n" +
                "\"Grill until golden brown on both sides\"";
        recipe = Recipe.builder()
                .id(UUID.randomUUID().toString())
                .name("Grilled Cheese Sandwich")
                .created(LocalDateTime.now())
                .vegan(false)
                .servings(4)
                .ingredients(ingredients2)
                .instructions(instructions2)
                .build();
        recipes.add(recipe);

        repository.saveAll(recipes)
                .map(Recipe::toString)
                .subscribe(log::info);

        log.info(" ==== List of recipes with details available at cache : ");
        repository.findAll()
                .map(Recipe::toString)
                .subscribe(log::info);
    }

}
