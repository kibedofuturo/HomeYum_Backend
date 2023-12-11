package home.yum.HomeYum_Backend.ingredient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IingredientService {
    Ingredient findById(Long ingredientId);

    Page<ListIngredientDTO> findAllIngredients(Pageable pagination);

    void saveIngredient(IngredientDTO data);

    void updateIngredient(UpdateIngredientDTO data);

    void deleteIngredient(Long ingredientId);
}
