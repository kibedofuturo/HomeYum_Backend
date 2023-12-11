package home.yum.HomeYum_Backend.rating;

import home.yum.HomeYum_Backend.user.User;

public record ListRatingDTO(
        long id,
        String text,
        int score,
        User author
) {
    public ListRatingDTO(Rating rating) {
        this(
                rating.getId(),
                rating.getText(),
                rating.getScore(),
                rating.getUser()
        );
    }
}
