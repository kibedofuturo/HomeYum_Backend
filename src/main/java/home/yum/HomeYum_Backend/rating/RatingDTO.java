package home.yum.HomeYum_Backend.rating;

import jakarta.validation.constraints.*;

public record RatingDTO(
        @NotBlank
        String text,
        @NotNull
        @Min(value = 1, message = "Score must be at least 1")
        @Max(value = 10, message = "Score must be at most 10")
        int score
) {
}
