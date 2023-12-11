package home.yum.HomeYum_Backend.recipes;

import jakarta.validation.constraints.NotNull;

public record UpdateRecipeDTO(
        @NotNull
        long id,
        String preparationmethod,
        Double preparationtime,
        Integer servingnumber,
        Dificulty dificulty
) {

}
