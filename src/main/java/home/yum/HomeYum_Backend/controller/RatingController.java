package home.yum.HomeYum_Backend.controller;

import home.yum.HomeYum_Backend.rating.Rating;
import home.yum.HomeYum_Backend.rating.RatingDTO;
import home.yum.HomeYum_Backend.rating.RatingRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rating")
public class RatingController {
    @Autowired
    private RatingRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RatingDTO data) {
        repository.save(new Rating(data));
    }


}
