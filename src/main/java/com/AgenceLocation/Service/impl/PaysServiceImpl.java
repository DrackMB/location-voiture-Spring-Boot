/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Service.facad.PaysService;
import com.AgenceLocation.bean.Pays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OuMaima
 */
@Service
public class PaysServiceImpl implements PaysService{
    @Autowired
    private PaysService paysService;

    @Override
    public Pays findByNom(String nom) {
        //To change body of generated methods, choose Tools | Templates.
        return paysService.findByNom(nom);
    }

    @Override
    public Pays deleteByNom(String nom) {
        //To change body of generated methods, choose Tools | Templates.
        return paysService.deleteByNom(nom);
    }

    @Override
    public void save(Pays pays) {
       //To change body of generated methods, choose Tools | Templates.
       paysService.save(pays);
    
    }

    @Override
    public List<Pays> findAll() {
   //To change body of generated methods, choose Tools | Templates.
    return paysService.findAll();
    }
    
}
