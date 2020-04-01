/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.VoiturePricing;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface VoiturePricingRepository extends JpaRepository<VoiturePricing, Long> {

    int deleteByCategorieLibelle(String  libelle);

    VoiturePricing findByCategorieLibelle(String libelle);
    
    List<VoiturePricing> findByAgenceNom(String nom);
    
    

    //VoiturePricing findByVoitureMatriculeLike(String matricule);
}
