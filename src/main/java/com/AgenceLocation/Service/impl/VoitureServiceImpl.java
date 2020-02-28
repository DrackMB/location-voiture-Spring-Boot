/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VoitureRepository;
import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public void deleteByVoitureMatricule(String matricule) {
        voitureRepository.deleteByVoitureMatricule(matricule);
    }

    @Override
    public int save(Voiture voiture) {
        voitureRepository.save(voiture);
        return 1;
    }

    @Override
    public Voiture findByMatricule(String matricule) {
        return voitureRepository.findByMatricule(matricule);
    }

}
