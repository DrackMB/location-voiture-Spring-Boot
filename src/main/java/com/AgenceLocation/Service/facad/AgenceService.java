/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Agence;
import java.util.List;

/**
 *
 * @author OuMaima
 */
public interface AgenceService {

    public Agence findByNom(String nom);

    public Agence deleteByNom(String nom);

    public void save(Agence agence);

    public List<Agence> findAll();

}
