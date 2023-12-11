package home.yum.HomeYum_Backend.recipes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecipeService implements IrecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Page<ListRecipeDTO> findAllRecipe(Pageable pagination) {
        return recipeRepository.findAllByActiveTrue(pagination).map(ListRecipeDTO::new);
    }

    @Override
    public Recipe findById(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @Override
    public void saveRecipe(RecipeDTO data) {
        recipeRepository.save(new Recipe(data));
    }

    @Override
    public void updateRecipe(UpdateRecipeDTO data) {
        var recipe = recipeRepository.getReferenceById(data.id());
        recipe.updateInfo(data);
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        var recipe = recipeRepository.getReferenceById(recipeId);
        recipe.delete();
    }
}
