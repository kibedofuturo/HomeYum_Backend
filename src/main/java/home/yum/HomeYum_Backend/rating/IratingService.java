package home.yum.HomeYum_Backend.rating;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IratingService {
    Rating findById(Long ratingId);

    Page<ListRatingDTO> findAllRatings(Pageable pagination);

    void saveRating(RatingDTO data);

    void updateRating(UpdateRatingDTO data);

    void deleteRating(Long ratingId);
}
