package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void recipeConstructorTest() {
        Recipe recipe = new Recipe("Palacsinta");
        assertEquals("Palacsinta", recipe.getName());

        Recipe recipe1 = new Recipe("Palacsinta","Hagyományos recept");
        assertEquals("Palacsinta", recipe1.getName());
        assertEquals("Hagyományos recept", recipe1.getDescription());
    }

    @Test
    void recipeAddIngredientTest() {
        Recipe recipe = new Recipe("Palacsinta","Hagyományos recept");
        recipe.addIngredient("Liszt");
        assertEquals(1, recipe.getIngredients().size());

        recipe.addIngredient("Víz", "Só", "Élesztő", "Cukor");
        assertEquals(5, recipe.getIngredients().size());
    }
}