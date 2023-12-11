package home.yum.HomeYum_Backend.ingredient;

import jakarta.validation.constraints.NotNull;

public record ListIngredientDTO(
        @NotNull
        long id,
        String name,
        Double value
) {
    public ListIngredientDTO(Ingredient ingredient) {
        this(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getValue()
        );
    }
}
