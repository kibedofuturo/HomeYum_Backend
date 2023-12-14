package home.yum.HomeYum_Backend.user;

import home.yum.HomeYum_Backend.recipes.Recipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> favRecipes;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> createdRecipes;

    @Column(name = "active", columnDefinition = "boolean USING active::boolean")
    private boolean active;

    public User(UserDTO data) {
        active = true;
        name = data.name();
        email = data.email();
        password = data.password();
    }

    public void UpdateInfo(UpdateUserDTO data) {
        if (this.name != null) {
            this.name = data.name();
        }
        if (this.email != null) {
            this.email = data.email();
        }
        if (this.password != null) {
            this.password = data.password();
        }
    }

    public void delete() {
        this.active = false;
    }
}
