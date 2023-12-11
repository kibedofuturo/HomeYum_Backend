package home.yum.HomeYum_Backend.rating;

import home.yum.HomeYum_Backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "rating")
@Entity(name = "Ratimg")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;
    private int score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Rating(RatingDTO data) {
        text = data.text();
        score = data.score();
    }
}
