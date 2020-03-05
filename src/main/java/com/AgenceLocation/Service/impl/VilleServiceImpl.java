/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VilleRepository;
import com.AgenceLocation.Service.facad.VilleService;
import com.AgenceLocation.bean.Ville;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OuMaima
 */
@Service
public class VilleServiceImpl implements VilleService{
    
    @Autowired
    public VilleRepository villeRepository;

    @Override
    public Ville findByNom(String nom) {
         //To change body of generated methods, choose Tools | Templates.
         return villeRepository.findByNom(nom);
    }

    @Override
    public int deleteByNom(String nom) {
         //To change body of generated methods, choose Tools | Templates.
         return villeRepository.deleteByNom(nom);
    }
    

    @Override
    public void save(Ville ville) {
        //To change body of generated methods, choose Tools | Templates.
        villeRepository.save(ville);
    }

    @Override
    public List<Ville> findAll() {
       //To change body of generated methods, choose Tools | Templates.
       return villeRepository.findAll();
    }
    
    
    
    
}
