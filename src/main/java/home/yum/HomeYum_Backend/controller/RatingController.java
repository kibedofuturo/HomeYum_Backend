package home.yum.HomeYum_Backend.controller;

import home.yum.HomeYum_Backend.rating.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RatingDTO data) {
        ratingService.saveRating(data);
    }

    @GetMapping
    public ResponseEntity<Page<ListRatingDTO>> getAllRatings(Pageable pagination){
        Page<ListRatingDTO> ratingPage = ratingService.findAllRatings(pagination);
        return ResponseEntity.ok(ratingPage);
    }

    @GetMapping("{ratingId}")
    public ResponseEntity<ListRatingDTO> getRatingById(@PathVariable Long ratingId) {
        Rating rating = ratingService.findById(ratingId);

        if (rating != null) {
            ListRatingDTO ratingDTO = new ListRatingDTO(rating);
            return ResponseEntity.ok(ratingDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateRatingDTO data) {
        ratingService.updateRating(data);
    }

    @DeleteMapping("{ratingId}")
    @Transactional
    public void delete(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
    }
}
