/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;


import com.AgenceLocation.Repository.ReviewRepository;
import com.AgenceLocation.Service.facad.ClientService;
import com.AgenceLocation.Service.facad.NoteService;
import com.AgenceLocation.Service.facad.ReviewService;
import com.AgenceLocation.bean.Client;
import com.AgenceLocation.bean.Note;
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
    ClientService clientService;
    @Autowired
    NoteService noteService ;
   // @Autowired
    //VoitureService voiturreService;
    
   @Autowired
   ReviewRepository reviewRepository;
    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
                }

   
    public int save(Review review) {
        Client foundedClient=clientService.findByCin(review.getClient().getCin());
        Note foundedNote=noteService.FindByLibelle(review.getNote().getLibelle());
      //  Voiture foundedVoiture=voitureRepository.findByMtricule(review.getVoiture().getMatricule());
        if(foundedClient==null){
            return -1;
        }else if(foundedNote==null){
            return -2;
        }//else if(foundedVoiture==null){return -3;}  
        else{
            reviewRepository.save(review);
            return 1;
        }
        
        

    }
    
    
}
