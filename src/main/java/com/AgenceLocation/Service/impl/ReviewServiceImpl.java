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
import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Review;
import com.AgenceLocation.bean.Note;
import com.AgenceLocation.bean.Client;
import com.AgenceLocation.bean.Voiture;
import java.util.List;
import java.util.Optional;
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
   @Autowired
   NoteService noteService;
   @Autowired
   VoitureService voitureService;        
   @Autowired
   ClientService clientService;
   
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    
    public int save(Review review) {
        Note foundedNote=noteService.findByLibelle(review.getNote().getLibelle());
        Client foundedClient=clientService.findByCin(review.getClient().getCin());
        Voiture foundedVoiture=voitureService.findByMatricule(review.getVoiture().getMatricule());
        Review foundedReview=findByReviewClientCinAndVoitureMatricule(review.getClient().getCin(),review.getVoiture().getMatricule() );
        if(foundedClient==null){
            return -1;
        }else if(foundedNote==null){
            return -2;
        }else if(foundedVoiture==null){
            return -3;}
        else if(foundedReview!=null){
             return -4;
            
        }else{
            review.setClient(foundedClient);
            review.setNote(foundedNote);
            review.setVoiture(foundedVoiture);
            reviewRepository.save(review);
            return 1;
        }
        
    }

    @Override
    public Review findByReviewClientCinAndVoitureMatricule(String cin, String Matricule) {
   return reviewRepository.findByReviewClientCinAndVoitureMatricule(cin, Matricule);    }
    
    public int deleteId(Long id) {
        return reviewRepository.deleteId(id);
    }

    @Override
    public int updateReview(Long id, String corps,String lib ) {
        Optional<Review> founded=reviewRepository.findById(id);
        Note foundedN=noteService.findByLibelle(lib);
        if(foundedN==null){
            return -1;
        }else{
        Review castedfounded=founded.get();
        castedfounded.setCorps(corps);
        castedfounded.setNote(foundedN);
        reviewRepository.save(castedfounded);
        return 1;
        }
        
    }

    }
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



