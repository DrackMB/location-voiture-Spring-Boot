/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.VilleService;
import com.AgenceLocation.bean.Ville;
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
@RequestMapping("/AgenceLocation/ville")
public class VilleRest {
    
    @Autowired
    private VilleService villeService;
    
    @GetMapping("/nom/{nom}")
    public Ville findByNom(@PathVariable String nom) {
        return villeService.findByNom(nom);
    }

    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable String nom) {
        return villeService.deleteByNom(nom);
    }

    @PostMapping("/")
    public void save(@RequestBody Ville ville) {
        villeService.save(ville);
    }

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }
    
    
}
