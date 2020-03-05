/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Voiture;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping("agencelocation/voiture")
public class VoitureRest {
    
     @Autowired
    private VoitureService voitureService;
    
    @PostMapping("/")
    public int save(@RequestBody Voiture voiture) {
       return voitureService.save(voiture);
      
    }

    @GetMapping("/")
    public List<Voiture> findAll() {
        return voitureService.findAll();
    }

    @GetMapping("/matricule/{matricule}")
    public Voiture findByMatricule(@PathVariable String matricule) {
        return voitureService.findByMatricule(matricule);
    }
    
    @GetMapping("/code/{code}")
    public List<Voiture> findByCode (@PathVariable String code){
        return voitureService.findByCode(code);
        
    }
    
}