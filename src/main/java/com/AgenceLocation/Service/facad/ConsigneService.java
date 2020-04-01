/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Consigne;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;
import org.springframework.stereotype.Service;

/**
 *
 * @author OuMaima
 */
@Service
public interface ConsigneService {

    int save(Consigne consigne) throws InstanceAlreadyExistsException;

    List<Consigne> findAll();

    Consigne findByLibelle(String libelle);

    int deleteByLibelle(String Libelle);

    List<Consigne> findByEtatLieuReference(String reference);

}
