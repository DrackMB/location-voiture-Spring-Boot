/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Marque;
import java.util.List;

/**
 *
 * @author HP
 */
public interface MarqueService {
    
    int save(Marque marque);

    List<Marque> findAll();

    Marque findByLibelle(String libelle);

    
}
