/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;
import com.AgenceLocation.bean.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aaoub
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
   public List<Review> findAll();
   @Query("DELETE from Review r where r.id=:id")
   int deleteId(@Param(value = "id") Long id);
   
 
    
}
