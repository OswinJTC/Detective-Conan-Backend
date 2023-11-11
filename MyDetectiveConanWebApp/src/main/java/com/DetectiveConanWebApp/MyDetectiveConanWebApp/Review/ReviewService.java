// ReviewService.java
package com.DetectiveConanWebApp.MyDetectiveConanWebApp.Review;

import com.DetectiveConanWebApp.MyDetectiveConanWebApp.Movie.Movie;
import com.DetectiveConanWebApp.MyDetectiveConanWebApp.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String MId, String writter){
        Review review = reviewRepository.insert(new Review(reviewBody, writter, LocalDateTime.now(), LocalDateTime.now()));
        review.setWritter(writter);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("MId").is(MId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        mongoTemplate.update(User.class)
                .matching(Criteria.where("username").is(writter))
                .apply(new Update().push("user_reviews").value(review))
                .first();
        return review;
    }
}
