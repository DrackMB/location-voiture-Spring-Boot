/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Review;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author aaoub
 */
@Service
public interface ReviewService {
  public List<Review> findAll();
      
}
