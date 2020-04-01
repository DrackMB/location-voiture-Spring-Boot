/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Agence;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;

/**
 *
 * @author OuMaima
 */
public interface AgenceService {

     List<Agence> findByNom(String nom);

     int deleteByNom(String nom);

     int save(Agence agence)throws InstanceAlreadyExistsException;

     List<Agence> findAll();
    
     List<Agence> findByVille(String nom);
    
     Agence findByCode(double code);
     
     int deleteByCode(double code);

}
