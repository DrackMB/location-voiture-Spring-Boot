/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Voiture;

/**
 *
 * @author dell
 */
public interface VoitureService {

    void deleteByVoitureMatricule(String matricule);

    int save(Voiture voiture);
    
    Voiture findByMatricule( String matricule);

}
