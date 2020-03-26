
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VoiturePricingRepository;
import com.AgenceLocation.Service.facad.AgenceService;
import com.AgenceLocation.Service.facad.CategorieService;
import com.AgenceLocation.Service.facad.VoiturePricingService;
import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Voiture;
import com.AgenceLocation.bean.VoiturePricing;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class VoiturePricingServiceImpl implements VoiturePricingService {

    @Autowired
    private VoiturePricingRepository voiturePricingRepository;
    @Autowired
    private VoitureService voitureService;

    @Override
    public List<VoiturePricing> findAll() {
        return voiturePricingRepository.findAll();
    }

    @Override
    public VoiturePricing findByCategorieLibelle(String libelle) {
        return voiturePricingRepository.findByCategorieLibelle(libelle);
    }

    @Override
    public int save(VoiturePricing voiturePricing, int porcentage) {
        int i = verifierDate(voiturePricing);
        if (voiturePricing != null) {
            VoiturePricing voiturePricings = findByCategorieLibelle(voiturePricing.getcategorie().getLibelle());
            Voiture voiture = voitureService.findByCategorieLibelle(voiturePricing.getcategorie().getLibelle());

            if (voiture != null) {

                if (voiturePricings == null) {
                    double finalPrice = (double) voiture.getPrixinitial() * porcentage;
                    voiturePricing.setPrix(finalPrice);
                    voiturePricing.setAgence(voiture.getAgence());
                    //voitureService.save(voiture);
                    voiturePricingRepository.save(voiturePricing);
                    return 1;
                } else {

                    if (voiturePricings.getDatefin().getTime() < voiturePricing.getDatefin().getTime()
                            && voiturePricings.getDateDebut().getTime() < new Date().getTime()) {
                        voiturePricings.setDatefin(voiturePricing.getDatefin());
                        voiturePricings.setPrix(((double) voiture.getPrixinitial() * porcentage) / 100);
                        voiturePricingRepository.save(voiturePricings);
                        return 2;
                    }
                      } if(voiturePricings.getDatefin().getTime()>voiturePricing.getDatefin().getTime()){
                              return -2;
                }
           }
           

        }
     return -3;
    }

        @Override
        public int deleteByCategorieLibelle
        (String libelle
        
            ) {
        return voiturePricingRepository.deleteByCategorieLibelle(libelle);
        }

        @Override
        public void checkeExistancePromo
        
            () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int updateVoiturePricing
        (String libelle, Date dateFinal
        , int porcentage
        
            ) {
        VoiturePricing voiturePricing = findByCategorieLibelle(libelle);
            if (voiturePricing == null) {
                return -1;
            }
            voiturePricing.setDateDebut(new Date());
            Voiture voiture = voitureService.findByCategorieLibelleAndAgenceNom(libelle, voiturePricing.getAgence().getNom());
            voiturePricing.setPrix(voiture.getPrixinitial() - (((double) voiture.getPrixinitial() * porcentage) / 100));
            voiturePricing.setDatefin(dateFinal);
            voiturePricingRepository.save(voiturePricing);
            return 1;
        }

        @Override
        public List<VoiturePricing> findByAgenceNom
        (String nom
        
            ) {
        return voiturePricingRepository.findByAgenceNom(nom);
        }

    

    private int verifierDate(VoiturePricing voiturePricing) {
        if (voiturePricing.getDatefin().getTime()<voiturePricing.getDateDebut().getTime() || voiturePricing.getDatefin().getTime()==voiturePricing.getDateDebut().getTime()) {
            return -1;
        }
        return 1;
    }
}
