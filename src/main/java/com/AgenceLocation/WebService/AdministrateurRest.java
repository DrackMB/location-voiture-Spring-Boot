/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.AdministrateurService;
import com.AgenceLocation.bean.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */
@RestController
@RequestMapping("/AgenceLocation")
public class AdministrateurRest {
    @Autowired
    private AdministrateurService administrateurService;
    @PostMapping("/")
    public void save(@RequestBody Administrateur administrateur) {
        administrateurService.save(administrateur);
    }
    
    
}
