/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Ville;
import java.util.List;

/**
 *
 * @author OuMaima
 */
public interface VilleService {

    public Ville findByNom(String nom);

    public int deleteByNom(String nom);

    public void save(Ville ville);

    public List<Ville> findAll();

}
