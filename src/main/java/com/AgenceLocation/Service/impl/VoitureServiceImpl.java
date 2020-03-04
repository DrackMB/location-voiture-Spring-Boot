/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.CarburantRepository;
import com.AgenceLocation.Repository.CategorieRepository;
import com.AgenceLocation.Repository.TransmitionRepository;
import com.AgenceLocation.Repository.VoitureRepository;
import com.AgenceLocation.Service.facad.CarburantService;
import com.AgenceLocation.Service.facad.CategorieService;
import com.AgenceLocation.Service.facad.TransmitionService;
import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Carburant;
import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Transmition;
//import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Voiture;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private CategorieService categorieService;

    /* @Autowired
    private CarburantService carburantService;
    @Autowired
    private TransmitionService transmitionService;*/

    @Override
    public int save(Voiture voiture) {
        Voiture foundedVoiture = findByMatricule(voiture.getMatricule());
        Categorie categories = categorieService.findByLibelle(voiture.getCategorie().getLibelle());
        if (foundedVoiture != null) {
            return -1;
        } else if (categories == null) {
            return -2;
        } else {
            /* carburantRepository.save(voiture.getCarburant());
            categorieRepository.save(voiture.getCategorie());
            transmitionRepository.save(voiture.getTransmition());*/
            voiture.setCategorie(categories);

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

    @Override
    public List<Voiture> findByCode(String code) {
        List<Voiture> res = new ArrayList();
        List<Voiture> voit = findAll();
        for (Voiture v : voit) {
            if (code == v.getAgence().getCode()) {
                res.add(v);

            }

        }
        return res;

    }
}
