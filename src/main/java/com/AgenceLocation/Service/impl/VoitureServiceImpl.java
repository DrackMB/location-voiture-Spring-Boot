




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VoitureRepository;
import com.AgenceLocation.Service.facad.AgenceService;

import com.AgenceLocation.Service.facad.CarburantService;
import com.AgenceLocation.Service.facad.CategorieService;
import com.AgenceLocation.Service.facad.TransmitionService;
import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Carburant;
import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Transmition;
import com.AgenceLocation.bean.Voiture;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private CarburantService carbuantService;
    @Autowired
    private AgenceService agenceService;
    @Autowired
    private TransmitionService transmitionService;

    /*@Override
    public int save(Voiture voiture) {
        /*System.out.println("fa9er dem + ma3nedha 3osbone");
        System.out.println("voiture = " + voiture);
        return -1;*/
        
    //}
    @Override
    public int save(Voiture voiture) {
        Voiture foundedVoiture = findByMatricule(voiture.getMatricule());
        Categorie categories = categorieService.findByLibelle(voiture.getCategorie().getLibelle());
        Carburant carburants = carbuantService.findByLibelle(voiture.getCarburant().getLibelle());
        Agence agences = agenceService.findByNom(voiture.getAgence().getNom());
        Transmition transmitions = transmitionService.findByLibelle(voiture.getTransmition().getLibelle());
        if (foundedVoiture != null) {
            return -1;
        } else if (categories == null) {
            return -2;
        } else if (carburants == null) {
            return -3;
        } else if (agences == null) {
            return -4;
        } else if (transmitions == null) {
            return -5;
        } else {
            voiture.setCategorie(categories);
            voiture.setTransmition(transmitions);
            voiture.setAgence(agences);
            voiture.setCarburant(carburants);
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
            if (code.equals(v.getAgence().getCode())) {
                res.add(v);

            }

        }
        return res;

    }

    @Override
    public Voiture findByCategorieLibelleAndAgenceNom(String libelle, String nom) {
        List <Voiture> res=findAll();
        Voiture voitr=null;
        for (Voiture voit : res) {
            if(libelle.equals(voit.getCategorie().getLibelle())&& nom.equals(voit.getAgence().getNom())){
                 voitr = voit;   
        }}
        
        return voitr;
        
    }

    @Override
    public Voiture findByCategorielibelle(String libelle,String code) {
        List<Voiture> resultat=findByCode(code);
        Voiture vo = null;
        for(Voiture r :resultat){
           if(libelle.equals(r.getCategorie().getLibelle())){
               vo=r;
           }
           
        }
       return vo;
    }

    @Transactional
    public int deleteByMatricule(String matricule) {
       return voitureRepository.deleteByMatricule(matricule);
    }
        

    @Override
    public List<Voiture> findByTransmitionLibelle(String libelle) {
       return voitureRepository.findByTransmitionLibelle(libelle);
    }

    @Override
    public List<Voiture> findByCarburantLibelle(String libelle) {
        return voitureRepository.findByCarburantLibelle(libelle);
    }

    @Override
    public int updateVoiture(String matricule,double moyenNote,int prixinitial) {
       Voiture v=voitureRepository.findByMatricule(matricule);
       if(v==null){
           return -1;
       }else{
           v.setMoyenNote(moyenNote);
           v.setPrixinitial(prixinitial);
           voitureRepository.save(v);
           return 1; 
       }
       

    }
    
   
    
    public Voiture findByCategorieLibelle(String libelle) {
        return voitureRepository.findByCategorieLibelle(libelle);
    }
}


