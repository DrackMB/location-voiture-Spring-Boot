/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Consigne;
import com.AgenceLocation.bean.EtatLieuItems;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;

/**
 *
 * @author OuMaima
 */
public interface EtatLieuItemsService {
     public List<EtatLieuItems> findBygravite(String gravite);

    public int deleteByGravite(String gravite);
    List<EtatLieuItems> findAll();
    int save(EtatLieuItems etatLieuItems)throws InstanceAlreadyExistsException ;
    
    
}
