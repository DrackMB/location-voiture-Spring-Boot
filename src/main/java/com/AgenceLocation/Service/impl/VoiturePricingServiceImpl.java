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
import javax.persistence.PrePersist;
import javax.transaction.Transactional;
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
    protected VoitureService voitureService;

    @Transactional
    @Override
    public void deleteByVoitureMatricule(String matricule) {
        voitureService.deleteByVoitureMatricule(matricule);
        voiturePricingRepository.deleteByVoitureMatricule(matricule);
    }

    @Transactional
    @PrePersist
    @Override
    public void checkeExistancePromo() {
        List<VoiturePricing> toutVoiturePricing = findAll();
        toutVoiturePricing.stream().filter((voiturePricing) -> (voiturePricing.getDatefin().getTime() > new Date().getTime())).forEachOrdered((voiturePricing) -> {
            for (Voiture voiture : voiturePricing.getVoitures()) {
                deleteByVoitureMatricule(voiture.getMatricule());
                voitureService.deleteByVoitureMatricule(voiture.getMatricule());

            }
        });
    }

    @Override
    public List<VoiturePricing> findAll() {
        return voiturePricingRepository.findAll();
    }

    //public VoiturePricing findByVoitureMatriculeLike(String matricule) {
    //return voiturePricingRepository.findByVoitureMatriculeLike(matricule);
    //}
    @Override
    public int save(Voiture voiture, VoiturePricing voiturePricing, int porcentage, Date dateFinal) {
        List<VoiturePricing> maVoiturePricing = findAll();
        for (VoiturePricing voiturePricing1 : maVoiturePricing) {
            for (Voiture voiture1 : voiturePricing1.getVoitures()) {
                if (voiture1.getMatricule().equals(voiture.getMatricule())) {
                    if (voiturePricing1.getDatefin().getTime() > new Date().getTime()) {
                        voiturePricing1.setDatefin(dateFinal);
                        return 1;
                    } else if (voiturePricing1.getDatefin().getTime() < new Date().getTime()) {
                        return -1;
                    }

                }
            }
        }
        int prix = voiture.getPrixInitial();
        voiturePricing.getVoitures().add(voiture);
        voiturePricing.setDateDebut(new Date());
        voiturePricing.setDatefin(dateFinal);
        voiturePricing.setPrix((double) prix * porcentage);
        voitureService.save(voiture);
        voiturePricingRepository.save(voiturePricing);
        return 2;
    }
}
