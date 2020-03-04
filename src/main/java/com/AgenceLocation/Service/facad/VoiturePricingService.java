/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Voiture;
import com.AgenceLocation.bean.VoiturePricing;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dell
 */
public interface VoiturePricingService {

    public List<VoiturePricing> findAll();

    // VoiturePricing findByVoitureMatriculeLike(String matricule);
    int save(Voiture voiture, int Porcentage, Date dateFinal,Date dateDebu);

    int deleteByCategorie(Categorie categorie);

    List<VoiturePricing> findByCategorie(Categorie categorie);

    void checkeExistancePromo();

}
