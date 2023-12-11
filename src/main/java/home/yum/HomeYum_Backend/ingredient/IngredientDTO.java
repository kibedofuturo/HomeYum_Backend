package home.yum.HomeYum_Backend.ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IngredientDTO(
        @NotBlank
        String name,
        @NotNull
        double value
) {
}
