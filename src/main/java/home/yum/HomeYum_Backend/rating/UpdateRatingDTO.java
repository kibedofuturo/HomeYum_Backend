package home.yum.HomeYum_Backend.rating;

import jakarta.validation.constraints.NotNull;
public record UpdateRatingDTO(
        @NotNull
        long id,
        String text,
        int score
) {
}
