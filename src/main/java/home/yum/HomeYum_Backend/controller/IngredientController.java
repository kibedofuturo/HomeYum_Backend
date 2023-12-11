package home.yum.HomeYum_Backend.controller;

import home.yum.HomeYum_Backend.ingredient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid IngredientDTO data) {
        ingredientService.saveIngredient(data);
    }

    @GetMapping
    public ResponseEntity<Page<ListIngredientDTO>> getAllIngredients(Pageable pagination){
        Page<ListIngredientDTO> ingredientPage = ingredientService.findAllIngredients(pagination);

        return ResponseEntity.ok(ingredientPage);
    }

    @GetMapping("/ingredientId")
    public ResponseEntity<ListIngredientDTO> getIngredientById(@PathVariable Long ingredientId) {
        Ingredient ingredient = ingredientService.findById(ingredientId);

        if(ingredient != null){
            ListIngredientDTO ingredientDTO = new ListIngredientDTO(ingredient);
            return ResponseEntity.ok(ingredientDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateIngredientDTO data) {
        ingredientService.updateIngredient(data);
    }

    @DeleteMapping("{ingredientId}")
    @Transactional
    public void delete(@PathVariable Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
    }
}
