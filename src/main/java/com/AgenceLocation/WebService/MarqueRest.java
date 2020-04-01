/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.MarqueService;
import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Marque;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("agencelocation/marque")
public class MarqueRest {
    
     @Autowired
    private MarqueService marqueService;

    @GetMapping("/")
    public List<Marque> findAll() {
        return marqueService.findAll();
    }

    @GetMapping("/libelle/{libelle}")
    public Marque findByLibelle(@PathVariable String libelle) {
        return marqueService.findByLibelle(libelle);
    }
    
    @PostMapping("/")
    public int save(@RequestBody Marque marque) {
        return marqueService.save(marque);
    }
  
    
    
}
