/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.CategorieRepository;
import com.AgenceLocation.Service.facad.CategorieService;
import com.AgenceLocation.bean.Categorie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */

@Service
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public int save(Categorie categorie) {
        Categorie foundedCategorie=findByLibelle(categorie.getLibelle());
        if(foundedCategorie!=null){
            return -1;
        }else{
            categorieRepository.save(categorie);
             return 1;
        }
       
        
        
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

