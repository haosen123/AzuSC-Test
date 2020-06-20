package com.sirius.feign;

import com.sirius.entity.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "review")
public interface ReviewFeign {
    @PostMapping("/review/save")
    public void addReview(@RequestBody Review review);

    @GetMapping("/review/findByRestName/{rname}")
    public List<Review> findByRestName(@PathVariable String rname);
}
