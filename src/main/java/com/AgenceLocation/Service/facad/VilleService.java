/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Ville;
import java.util.List;
import javassist.NotFoundException;
import javax.management.InstanceAlreadyExistsException;

/**
 *
 * @author OuMaima
 */
public interface VilleService {

    public Ville findByNom(String nom);

    public int deleteByNom(String nom);

    public int save(Ville ville) throws  NotFoundException , InstanceAlreadyExistsException ;

    public List<Ville> findAll();
    
 
    

}
