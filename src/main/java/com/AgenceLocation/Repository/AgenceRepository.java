/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Ville;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author OuMaima
 */
@Repository
 public interface AgenceRepository extends JpaRepository<Agence, Long>{
    
     List<Agence> findByNom(String nom);
     int deleteByNom(String nom);
     List<Agence> findByVille(String nom);
     Agence findByCode(String  code);
     Agence findByNomAndVille(String nom,Ville ville);
     int deleteByCode(String code);
    
}
