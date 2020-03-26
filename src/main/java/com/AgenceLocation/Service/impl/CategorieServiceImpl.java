/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.CategorieRepository;
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
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    private CategorieRepository categorieRepository;
     @Autowired
     private MarqueService marqueService;
    
    @Override
    public int save(Marque marque,List<Categorie> categories) {
       for(Categorie categorie:categories){
       categorie.setMarque(marque);
       categorieRepository.save(categorie);
       }
             return 1;
        }
    
    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie findByLibelle(String libelle) {
         return categorieRepository.findByLibelle(libelle);
    }
        
    
}

