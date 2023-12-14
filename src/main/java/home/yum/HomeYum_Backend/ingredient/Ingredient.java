package home.yum.HomeYum_Backend.ingredient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ingredients")
@Entity(name = "Ingredient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Double value;

    @Column(name = "active", columnDefinition = "boolean USING active::boolean")
    private boolean active;

    public Ingredient(IngredientDTO data) {
        active = true;
        name = data.name();
        value = data.value();
    }

    public void UpdateInfo(UpdateIngredientDTO data) {
        if (this.name != null) {
            this.name = data.name();
        }
        if (this.value != null) {
            this.value = data.value();
        }
    }

    public void delete() {
        this.active = false;
    }
}
