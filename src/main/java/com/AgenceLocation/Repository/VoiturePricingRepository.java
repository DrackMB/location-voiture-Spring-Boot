/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.VoiturePricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface VoiturePricingRepository extends JpaRepository<VoiturePricing, Long> {

    @Query("delete from VoiturePricing where id = (select v.id from Voiture v where matricule=:matricule) ")
    void deleteByVoitureMatricule(String matricule);
    
    //VoiturePricing findByVoitureMatriculeLike(String matricule);
}
