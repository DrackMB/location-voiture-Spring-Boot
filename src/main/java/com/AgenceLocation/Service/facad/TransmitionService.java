/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Transmition;
import java.util.List;

/**
 *
 * @author dell
 */
public interface TransmitionService {

    int save(Transmition transmition);
    Transmition findByLibelle(String libelle);
    List<Transmition> findAll();

}
