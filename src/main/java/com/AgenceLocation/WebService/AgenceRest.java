/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.AgenceService;
import com.AgenceLocation.bean.Agence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author OuMaima
 */
@RestController
@RequestMapping("/AgenceLocation/agence")
public class AgenceRest {
    @Autowired
    public AgenceService agenceService;
 
    @DeleteMapping("/nom/{nom}")
    public Agence deleteByNom( @PathVariable String nom) {
        return agenceService.deleteByNom(nom);
    }

    @GetMapping("/nom/{nom}")
    public Agence findByNom(@PathVariable String nom) {
        return agenceService.findByNom(nom);
    }

    @PostMapping("/")
    public void save(@RequestBody Agence agence) {
        agenceService.save(agence);
    }

    @GetMapping("/")
    public List<Agence> findAll() {
        return agenceService.findAll();
    }
    
    
    
}
