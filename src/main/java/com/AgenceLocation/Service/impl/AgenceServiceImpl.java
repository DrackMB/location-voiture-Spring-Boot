/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.AgenceRepository;
import com.AgenceLocation.Service.facad.AgenceService;
import com.AgenceLocation.bean.Agence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author OuMaima
 */
public class AgenceServiceImpl implements AgenceService{
    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public Agence findByNom(String nom) {
         //To change body of generated methods, choose Tools | Templates.
         return agenceRepository.findByNom(nom);
    }
    
    @Override
    public Agence deletByNom(String nom) {
        //To change body of generated methods, choose Tools | Templates.
        return agenceRepository.deletByNom(nom);
    }

    @Override
    public void save(Agence agence) {
         //To change body of generated methods, choose Tools | Templates.
         agenceRepository.save(agence);
    }

    @Override
    public List<Agence> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        return agenceRepository.findAll();
    }

    
    
    
}
