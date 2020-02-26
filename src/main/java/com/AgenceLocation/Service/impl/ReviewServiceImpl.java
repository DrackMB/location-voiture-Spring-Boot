/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.ReviewRepository;
import com.AgenceLocation.Service.facad.ReviewService;
import com.AgenceLocation.bean.Review;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aaoub
 */
@Service
public class ReviewServiceImpl implements ReviewService {
   @Autowired
   ReviewRepository reviewRepository;
    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
                }
    
    
}
