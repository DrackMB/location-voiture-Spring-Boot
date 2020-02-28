/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.ReviewService;
import com.AgenceLocation.bean.Review;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aaoub
 */
@RestController
@RequestMapping("AgenceLocation/review")
public class ReviewRest {
  @Autowired
  ReviewService reviewService;
    
    @GetMapping("/")
    public List<Review> findAll() {
        return reviewService.findAll();
    }
  
    
}
