/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Pays;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;

/**
 *
 * @author OuMaima
 */

public interface PaysService {
    public Pays findByNom(String nom);
    public int deleteByNom(String nom);
    public int save(Pays pays)throws InstanceAlreadyExistsException;
    public List<Pays> findAll();
 
    
}
