package home.yum.HomeYum_Backend.recipes;

import home.yum.HomeYum_Backend.ingredient.Ingredient;
import home.yum.HomeYum_Backend.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "recipes")
@Entity(name = "Recipe")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Recipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String preparationmethod;
    private double preparationtime;
    private int servingnumber;

    @Enumerated(EnumType.STRING)
    private Dificulty dificulty;
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipe_id")
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private Boolean active;

    public Recipe(RecipeDTO data){
        active = true;
        name = data.name();
        preparationmethod = data.preparationmethod();
        preparationtime = data.preparationtime();
        servingnumber = data.servingnumber();
        dificulty = data.dificulty();
        category = data.category();
    }

    public void updateInfo(UpdateRecipeDTO data) {
        if(data.preparationmethod() != null) {
            this.preparationmethod = data.preparationmethod();
        }
        if(data.preparationtime() != null){
            this.preparationtime = data.preparationtime();
        }
        if(data.servingnumber() != null){
            this.servingnumber = data.servingnumber();
        }
        if(data.dificulty() != null){
            this.dificulty = data.dificulty();
        }
    }

    public void delete() {
        this.active = false;
    }
}
