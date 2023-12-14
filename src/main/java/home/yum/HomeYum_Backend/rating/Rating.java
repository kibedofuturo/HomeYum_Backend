package home.yum.HomeYum_Backend.rating;

import home.yum.HomeYum_Backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ratings")
@Entity(name = "Ratimg")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "active", columnDefinition = "boolean USING active::boolean")
    private boolean active;

    public Rating(RatingDTO data) {
        active = true;
        text = data.text();
        score = data.score();
    }

    public void UpdateInfo(UpdateRatingDTO data) {
        if (this.text != null) {
            this.text = data.text();
        }
        if (this.score != null) {
            this.score = data.score();
        }
    }

    public void delete() {
        this.active = false;
    }
}
