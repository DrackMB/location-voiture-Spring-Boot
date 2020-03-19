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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

     @GetMapping("/cin/{cin}/Matricule/{Matricule}")
    public Review findByClientCinAndVoitureMatricule(@PathVariable String cin,@PathVariable String Matricule) {
        return reviewService.findByClientCinAndVoitureMatricule(cin, Matricule);
    }
    @PutMapping("/id/{id}/corps/{corps}/lib/{lib}")
    public int updateReview(@PathVariable Long id,@PathVariable String corps,@PathVariable String lib) {
        return reviewService.updateReview(id, corps, lib);
    }

    @DeleteMapping("/")
    public int deleteId(@RequestBody Review review) {
        return reviewService.deleteId(review);
    }
    
    @PostMapping("/")
    public int save(@RequestBody Review review) {
        return reviewService.save(review);
    }
    
    @GetMapping("/")
    public List<Review> findAll() {
        return reviewService.findAll();
    }
      
    
}
