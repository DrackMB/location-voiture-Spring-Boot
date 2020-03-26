/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.MarqueRepository;
import com.AgenceLocation.Service.facad.CategorieService;
import com.AgenceLocation.Service.facad.MarqueService;
import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Marque;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */

@Service
public class MarqueServiceImpl implements MarqueService{
    
    @Autowired
     private MarqueRepository marqueRepository;

    @Autowired
    private CategorieService categorieService;
    @Override
    public int save(Marque marque) {
       
         Marque foundedMarque=findByLibelle(marque.getLibelle());

        if(foundedMarque!=null){
            return -1;
        }
            else{
             marqueRepository.save(marque);
             categorieService.save(marque,marque.getCategorie());
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
