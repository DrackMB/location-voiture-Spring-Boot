/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

//    @Query("delete from Voiture where matricule like :matricule ")
    void deleteByVoitureMatricule( String matricule);

//    @Query("SELECT v from Voiture where v.matricule=:matricule")
    Voiture findByMatricule( String matricule);

}
