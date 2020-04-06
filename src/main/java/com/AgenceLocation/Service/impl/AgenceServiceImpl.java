/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.AgenceRepository;
import com.AgenceLocation.Service.facad.AgenceService;
import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Ville;
import java.util.ArrayList;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OuMaima
 */
@Service

public class AgenceServiceImpl implements AgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public List<Agence> findByNom(String nom) {

        return agenceRepository.findByNom(nom);
    }

    @Override
    @Transactional
    public int deleteByNom(String nom) {
        //if(nom == null) nom="";
        List<Agence> foundedAgences = findByNom(nom);
        if (foundedAgences.size() > 0) {
            return agenceRepository.deleteByNom(nom);
        }
        return 0;
    }

    @Override
    public int save(Agence agence) throws InstanceAlreadyExistsException {
        if (agenceRepository.findByNomAndVille(agence.getNom(), agence.getVille()) == null) {
            agenceRepository.save(agence);
            return 1;
        }

        throw new InstanceAlreadyExistsException("exist");
    }

    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public List<Agence> findByVille(String nom) {
        return agenceRepository.findByVille(nom);
    }

    @Override
    public Agence findByCode(String code) {
        return agenceRepository.findByCode(code);
    }

    @Override
    public int deleteByCode(String  code) {

        Agence foundedAgence = findByCode(code);
        if (foundedAgence != null) {

            return agenceRepository.deleteByCode(code);
        }
        return -1;

    }

    @Override
    public int updateAgence(String nom, String adress, Long numTele,String code, String  nvCode, Ville ville) {

        Agence foundedAgence = agenceRepository.findByCode(code);
        if (nvCode == null) {
            return -1;
        } else {

            foundedAgence.setNom(nom);
            foundedAgence.setAdress(adress);
            foundedAgence.setNumTele(numTele);
            foundedAgence.setCode(nvCode);
            foundedAgence.setVille(ville);
            agenceRepository.save(foundedAgence);
            return 1;
        }
    }
}
