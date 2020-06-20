package com.sirius.controller;

import com.sirius.entity.Review;
import com.sirius.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/review")
@RestController
public class ReviewHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findByRestName/{rname}")
    public List<Review> findByRestName(@PathVariable("rname") String rname){
        return reviewRepository.findByRestName(rname);
    }

    @PostMapping("/save")
    public void save(@RequestBody Review review){
        Date date = new Date();
        review.setDate(date);
        reviewRepository.save(review);
    }

    @DeleteMapping("/deleteByReviewId/{id}")
    public void deleteByReviewId(@PathVariable("id") long id){
        reviewRepository.deleteByReviewId(id);
    }
}
