/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Review;
import java.util.List;

/**
 *
 * @author aaoub
 */
public interface ReviewService {
  public List<Review> findAll();
  public int save(Review review);
  int deleteId(Long id);
  
  
}
