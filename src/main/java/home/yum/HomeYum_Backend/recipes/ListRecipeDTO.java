package home.yum.HomeYum_Backend.recipes;

public record ListRecipeDTO(
        long id,
        String name,
        String preparationmethod,
        Double preparationtime,
        int servingnumber,
        Dificulty dificulty,
        Category category
) {
    public ListRecipeDTO(Recipe recipe) {
        this(
                recipe.getId(),
                recipe.getName(),
                recipe.getPreparationmethod(),
                recipe.getPreparationtime(),
                recipe.getServingnumber(),
                recipe.getDificulty(),
                recipe.getCategory()
        );
    }
}
