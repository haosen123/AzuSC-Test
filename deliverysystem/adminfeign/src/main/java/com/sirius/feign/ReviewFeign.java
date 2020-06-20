package com.sirius.feign;

import com.sirius.entity.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "review")
public interface ReviewFeign {
    @GetMapping("/review/findByRestId/{id}")
    public List<Review> findByRestId(@PathVariable long id);

    @DeleteMapping("/review/deleteByReviewId/{id}")
    public void deleteByReviewId(@PathVariable long id);
}
