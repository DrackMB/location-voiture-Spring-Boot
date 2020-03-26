/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

//import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Voiture;
import java.util.List;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    Voiture findByCategorieLibelleAndAgenceNom(String libelle, String nom);

    Voiture findByMatricule(String matricule);

    int deleteByMatricule(String matricule);

    List<Voiture> findByTransmitionLibelle(String libelle);

    List<Voiture> findByCarburantLibelle(String libelle);
    
    Voiture findByCategorieLibelle(String libelle);

}
