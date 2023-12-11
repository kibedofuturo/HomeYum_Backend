package home.yum.HomeYum_Backend.ingredient;

import jakarta.validation.constraints.NotNull;

public record UpdateIngredientDTO(
        @NotNull
        long id,
        String name,
        double value
) {
}
