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

     List<VoiturePricing> findAll();

    int save(VoiturePricing voiturePricing, int porcentage);

    int deleteByCategorieLibelle(String libelle);
    // veifier avec le prof

    VoiturePricing findByCategorieLibelle(String libelle);

    void checkeExistancePromo();

    int updateVoiturePricing(String libelle, Date dateFinal, int porcentage);

    List<VoiturePricing> findByAgenceNom(String nom);

}
