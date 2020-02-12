/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.AdministrateurRepository;
import com.AgenceLocation.Service.facad.AdministrateurService;
import com.AgenceLocation.bean.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class AdministrateurServiceImpl implements AdministrateurService {
    @Autowired
    private AdministrateurRepository administrateurRepository;

    @Override
    public void save(Administrateur administrateur) {
        administrateurRepository.save(administrateur);
    }

}
