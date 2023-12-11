package home.yum.HomeYum_Backend.rating;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class RatingService implements IratingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating findById(Long ratingId) {
        return ratingRepository.findById(ratingId).orElse(null);
    }

    @Override
    public Page<ListRatingDTO> findAllRatings(Pageable pagination) {
        return ratingRepository.findAllByActiveTrue(pagination).map(ListRatingDTO::new);
    }

    @Override
    public void saveRating(RatingDTO data) {
        ratingRepository.save(new Rating(data));
    }

    @Override
    public void updateRating(UpdateRatingDTO data) {
        var rating = ratingRepository.getReferenceById(data.id());
        rating.UpdateInfo(data);
    }

    @Override
    public void deleteRating(Long ratingId) {
        var rating = ratingRepository.getReferenceById(ratingId);
        rating.delete();
    }
}
