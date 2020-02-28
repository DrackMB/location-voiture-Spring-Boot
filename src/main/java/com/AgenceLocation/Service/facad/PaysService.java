/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Pays;
import java.util.List;

/**
 *
 * @author OuMaima
 */
public interface PaysService {
    public Pays findByNom(String nom);
    public Pays deletByNom(String nom);
    public void save(Pays pays);
    public List<Pays> findAll();
    
}
