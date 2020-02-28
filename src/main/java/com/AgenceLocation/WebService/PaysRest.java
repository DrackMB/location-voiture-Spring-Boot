/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.PaysService;
import com.AgenceLocation.bean.Pays;
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
@RequestMapping("agenceLocation/agence")
public class PaysRest {
    @Autowired
    private PaysService paysService;

    @GetMapping("/nom/{nom}")
    public Pays findByNom(@PathVariable String nom) {
        return paysService.findByNom(nom);
    }

    @DeleteMapping("/nom/{nom}")
    public Pays deletByNom(@PathVariable String nom) {
        return paysService.deletByNom(nom);
    }

    @PostMapping("/")
    public void save(@RequestBody Pays pays) {
        paysService.save(pays);
    }

    @GetMapping("/")
    public List<Pays> findAll() {
        return paysService.findAll();
    }
    
}
