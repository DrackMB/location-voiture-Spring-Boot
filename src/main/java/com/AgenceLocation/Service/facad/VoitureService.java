/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;


import com.AgenceLocation.bean.Voiture;
import java.util.List;

/**
 *
 * @author HP
 */
public interface VoitureService {
     int save(Voiture voiture);
    List<Voiture>findAll();
    Voiture findByMatricule(String matricule);
    
}
