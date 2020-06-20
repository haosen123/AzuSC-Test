package com.sirius.controller;

import com.sirius.entity.Review;
import com.sirius.feign.ReviewFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/review")
public class ReviewHandler {

    @Autowired
    private ReviewFeign reviewFeign;

    @GetMapping("/findByRestId/{id}")
    public List<Review> findByRestId(@PathVariable long id){
        return reviewFeign.findByRestId(id);
    }

    @DeleteMapping("/deleteByReviewId/{id}")
    public void deleteByReviewId(@PathVariable long id){
        reviewFeign.deleteByReviewId(id);
    }

}
