/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.CategorieService;
import com.AgenceLocation.bean.Categorie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("agencelocation/categorie")
public class CategorieRest {
    
    @Autowired
    private CategorieService categorieService;
    
    @PostMapping("/")
    public int save(@RequestBody Categorie categorie) {
       return categorieService.save(categorie);
      
    }

    @GetMapping("/")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @GetMapping("/libelle/{libelle}")
    public Categorie findByLibelle(String libelle) {
        return categorieService.findByLibelle(libelle);
    }
    
    
    
    
}
