package Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredient {

    @Id
    private String name;

    @Column(nullable = false)
    private int calories;

    @Column(nullable = false)
    private int price;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ingredient")
    private Set<Recipe_Ingredient> recipe;

    public Ingredient(){
    }

    public Ingredient(String name, int calories, int price){
        setName(name);
        setCalories(calories);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getPrice() {
        return price;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCalories(int calories) {
        this.calories = calories;
    }

    private void setPrice(int price) {
        this.price = price;
    }
}
