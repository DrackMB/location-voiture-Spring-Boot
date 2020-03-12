
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface CarburantRepository extends JpaRepository<Carburant, Long>{
    Carburant findByLibelle(String libelle);

    public Carburant deleteByLibelle(String libelle);
    
}

