package home.yum.HomeYum_Backend.recipes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IrecipeService {
    Recipe findById(Long recipeId);

    Page<ListRecipeDTO> findAllRecipe(Pageable pagination);

    void saveRecipe(RecipeDTO data);

    void updateRecipe(UpdateRecipeDTO data);

    void deleteRecipe(Long recipeId);
}
