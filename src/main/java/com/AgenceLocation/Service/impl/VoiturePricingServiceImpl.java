/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VoiturePricingRepository;
import com.AgenceLocation.Service.facad.VoiturePricingService;
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
    

    @Override
    public List<VoiturePricing> findAll() {
        return voiturePricingRepository.findAll();
           }

    @Override
    public int save(Voiture voiture, int porcentage, Date dateFinal, Date dateDebu) {
        
        if(dateFinal.before(dateDebu)||dateFinal.equals(dateDebu)){
            return -1;
        } else {
         List <VoiturePricing> voiturePricings =findByCategorie(voiture.getCategorie());
         if (voiturePricings.isEmpty()){
           VoiturePricing voiturePricing=new VoiturePricing();
           double finalPrice=(double) voiture.getPrixInitial()*porcentage;
           voiturePricing.setPrix(finalPrice);
           voiturePricing.setDateDebut(dateDebu);
           voiturePricing.setDatefin(dateFinal);
           voiturePricing.setcategorie(voiture.getCategorie());
           voiturePricing.setAgence(voiture.getAgence());
           voiturePricingRepository.save(voiturePricing);
           return 1;
         }       for(VoiturePricing voiturePricing :voiturePricings){
                 if(voiturePricing.getDatefin().getTime()<dateFinal.getTime()
                         && voiturePricing.getDateDebut().getTime()<new Date().getTime()
                         ){
                     voiturePricing.setDatefin(dateFinal);
                     voiturePricing.setPrix((double)voiture.getPrixInitial()*porcentage);
                     voiturePricingRepository.save(voiturePricing);
                     return  2;
                     
                 }else if(voiturePricing.getDatefin().getTime()>dateFinal.getTime()){
                     return -2;
                 }
             }
        }
        return -3;
    }

    @Override
    public int deleteByCategorie(Categorie categorie) {
        return voiturePricingRepository.deleteByCategorie(categorie);
    }

    @Override
    public List<VoiturePricing> findByCategorie(Categorie categorie) {
        return voiturePricingRepository.findByCategorie(categorie);
    }

    @Override
    public void checkeExistancePromo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
