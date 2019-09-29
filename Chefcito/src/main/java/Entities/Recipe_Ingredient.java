package Entities;

import javax.persistence.*;

@Entity

@Table(name = "RECIPE_INGREDIENT")
public class Recipe_Ingredient {

    @Id
    int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;

    public Recipe_Ingredient(){
    }

    public Recipe_Ingredient(Recipe recipe, Ingredient ingredient){
        setRecipe(recipe);
        setIngredient(ingredient);
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    private void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    private void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
