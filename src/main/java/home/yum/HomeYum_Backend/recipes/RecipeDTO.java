package home.yum.HomeYum_Backend.recipes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecipeDTO(
        @NotBlank
        String name,
        @NotBlank
        String preparationmethod,
        @NotNull
        double preparationtime,
        int servingnumber,
        Dificulty dificulty,
        Category category
) {
        public RecipeDTO(Recipe recipe) {
                this(
                        recipe.getName(),
                        recipe.getPreparationmethod(),
                        recipe.getPreparationtime(),
                        recipe.getServingnumber(),
                        recipe.getDificulty(),
                        recipe.getCategory()
                );
        }

}
