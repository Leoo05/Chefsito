package Entities;


import javax.persistence.*;
import java.util.Set;

@Entity

@Table(name = "RECIPE")
public class Recipe {

    @Id
    private String title;

   // @Column(nullable = false)
    //private Image image;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int calories;

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String instructions;

    @Column(nullable = false)
    private String video;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<Recipe_Ingredient> ingredients;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "recipe")
    private Set<Keep> keeps;

    public Recipe(){
    }

    public Recipe(String title, String type, int calories,
           String tag, String description, String instructions, String video){
        setTitle(title);
        setType(type);
        setCalories(calories);
        setTag(tag);
        setDescription(description);
        setInstructions(instructions);
        setVideo(video);
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getVideo() {
        return video;
    }

    public Set<Recipe_Ingredient> getIngredients() {
        return ingredients;
    }

    public Set<Keep> getKeeps() {
        return keeps;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setType(String type){
        this.type = type;
    }

    private void setCalories(int calories){
        this.calories = calories;
    }

    private void setTag(String tag){
        this.tag = tag;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private void setInstructions(String instructions){
        this.instructions = instructions;
    }

    private void setVideo(String url){
        this.video = url;
    }
}
