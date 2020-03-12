/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Transmition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dell
 */
public interface TransmitionRepository extends  JpaRepository<Transmition, Long>{
    
    Transmition findByLibelle(String libelle);
    
}
