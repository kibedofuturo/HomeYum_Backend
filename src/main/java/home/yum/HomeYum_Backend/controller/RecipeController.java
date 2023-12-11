package home.yum.HomeYum_Backend.controller;

import home.yum.HomeYum_Backend.recipes.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("recipes")
public class RecipeController {
    @Autowired
    private  RecipeService recipeService;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RecipeDTO data){
        recipeService.saveRecipe(data);
    }

    @GetMapping
    public ResponseEntity<Page<ListRecipeDTO>> getAllRecipes(Pageable pagination) {
        Page<ListRecipeDTO> recipePage = recipeService.findAllRecipe(pagination);
        return ResponseEntity.ok(recipePage);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<ListRecipeDTO> getRecipeById(@PathVariable Long recipeId) {
        Recipe recipe = recipeService.findById(recipeId);

        if (recipe != null) {
            ListRecipeDTO recipeDTO = new ListRecipeDTO(recipe);
            return ResponseEntity.ok(recipeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateRecipeDTO data) {
        recipeService.updateRecipe(data);
    }

    @DeleteMapping("/{recipeId}")
    @Transactional
    public void delete(@PathVariable Long recipeId){
        recipeService.deleteRecipe(recipeId);
    }
}
