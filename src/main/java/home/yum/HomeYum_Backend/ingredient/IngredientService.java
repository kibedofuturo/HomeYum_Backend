package home.yum.HomeYum_Backend.ingredient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IngredientService implements IingredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Page<ListIngredientDTO> findAllIngredients(Pageable pagination) {
        return ingredientRepository.findAllByActiveTrue(pagination).map(ListIngredientDTO::new);
    }

    @Override
    public Ingredient findById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId).orElse(null);
    }

    @Override
    public void saveIngredient(IngredientDTO data) {
        ingredientRepository.save(new Ingredient(data));
    }

    @Override
    public void updateIngredient(UpdateIngredientDTO data) {
        var ingredient = ingredientRepository.getReferenceById(data.id());
        ingredient.UpdateInfo(data);
    }

    @Override
    public void deleteIngredient(Long ingredientId) {
        var ingredient = ingredientRepository.getReferenceById(ingredientId);
        ingredient.delete();
    }
}
