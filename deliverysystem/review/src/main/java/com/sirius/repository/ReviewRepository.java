package com.sirius.repository;

import com.sirius.entity.Review;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewRepository {
    public List<Review> findByRestName(String rname);
    public void save(Review review);
    public void deleteByReviewId(long id);
}
