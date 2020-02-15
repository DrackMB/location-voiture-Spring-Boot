/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.CategorieRepository;
import com.AgenceLocation.Repository.MarqueRepository;
import com.AgenceLocation.Service.facad.MarqueService;
import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Marque;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HP
 */
public class MarqueServiceImpl implements MarqueService{
    
    @Autowired
     private MarqueRepository marqueRepository;

    @Override
    public int save(Marque marque) {
       
         Marque foundedMarque=findByLibelle(marque.getLibelle());
        if(foundedMarque!=null){
            return -1;
        }else{
             marqueRepository.save(marque);
             return 1;
        }
       
    }

    @Override
    public List<Marque> findAll() {
        return marqueRepository.findAll();
    }

    @Override
    public Marque findByLibelle(String libelle) {
        return marqueRepository.findByLibelle(libelle);
    }
   
}
