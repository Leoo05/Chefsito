package Entities;

import javax.persistence.*;

@Entity

@Table(name = "KEEP")
public class Keep {
    @Id
    int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Recipe recipe;

    public Keep(){
    }

    public  Keep(User user, Recipe recipe){
        setUser(user);
        setRecipe(recipe);
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public User getUser() {
        return user;
    }

    private void setUser(User user){
        this.user = user;
    }

    private void setRecipe(Recipe recipe){
        this.recipe = recipe;
    }
}
