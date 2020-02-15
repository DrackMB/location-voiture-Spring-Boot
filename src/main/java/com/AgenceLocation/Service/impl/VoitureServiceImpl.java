/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VoitureRepository;
import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Voiture;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HP
 */
public class VoitureServiceImpl implements VoitureService{
    
    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public int save(Voiture voiture) {
        Voiture foundedVoiture=findByMatricule(voiture.getMatricule());
        if(foundedVoiture!=null){
            return -1;
        }else{
            voitureRepository.save(voiture);
             return 1;
        }
       
    }

    @Override
    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture findByMatricule(String matricule) {
        return voitureRepository.findByMatricule(matricule);
    }
    
}
