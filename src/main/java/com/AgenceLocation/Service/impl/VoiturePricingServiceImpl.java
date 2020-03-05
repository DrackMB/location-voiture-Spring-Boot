/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VoiturePricingRepository;
import com.AgenceLocation.Service.facad.VoiturePricingService;
import com.AgenceLocation.Service.facad.VoitureService;
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
    private VoitureService voitureService ;
    

    @Override
    public List<VoiturePricing> findAll() {
        return voiturePricingRepository.findAll();
           }
    @Override
    public int save(Voiture voiture, int porcentage, Date dateFinal, Date dateDebu) {
        if(dateFinal.before(dateDebu)||dateFinal.equals(dateDebu)){
            return -1;
        } else {
         VoiturePricing voiturePricings = findByCategorieLibelle(voiture.getCategorie().getLibelle());
         if (voiturePricings==null){
           VoiturePricing voiturePricing=new VoiturePricing();
           double finalPrice=(double) voiture.getPrixInitial()*porcentage;
           voiturePricing.setPrix(finalPrice);
           voiturePricing.setDateDebut(dateDebu);
           voiturePricing.setDatefin(dateFinal);
           voiturePricing.setcategorie(voiture.getCategorie());
           voiturePricing.setAgence(voiture.getAgence());
           voiturePricingRepository.save(voiturePricing);
           return 1;
         }       else {
                 if(voiturePricings.getDatefin().getTime()<dateFinal.getTime()
                         && voiturePricings.getDateDebut().getTime()<new Date().getTime()
                         ){
                     voiturePricings.setDatefin(dateFinal);
                     voiturePricings.setPrix(((double)voiture.getPrixInitial()*porcentage)/100);
                     voiturePricingRepository.save(voiturePricings);
                     return  2;
                     
                 }else if(voiturePricings.getDatefin().getTime()>dateFinal.getTime()){
                     return -2;
                 }
             }
        }
        return -3;
    }

    @Override
    public int deleteByCategorieLibelle(String  libelle) {
        return voiturePricingRepository.deleteByCategorieLibelle(libelle);
    }

    @Override
    public  VoiturePricing findByCategorieLibelle(String libelle) {
        return voiturePricingRepository.findByCategorieLibelle(libelle);
    }

    @Override
    public void checkeExistancePromo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateVoiturePricing(String libelle, Date dateFinal, int porcentage) {
        VoiturePricing voiturePricing =findByCategorieLibelle(libelle);
        if(voiturePricing==null){
            return -1;
        }
        voiturePricing.setDateDebut(new Date());
        Voiture voiture = voitureService.findByCategorieLibelleAndAgenceNom(libelle, voiturePricing.getAgence().getNom());
        voiturePricing.setPrix( voiture.getPrixInitial()-(((double)voiture.getPrixInitial()*porcentage)/100));
        voiturePricing.setDatefin(dateFinal);
        voiturePricingRepository.save(voiturePricing);
        return 1;
    }

    @Override
    public List<VoiturePricing> findByAgenceNom(String nom) {
        return voiturePricingRepository.findByAgenceNom(nom);
    }

    
}
