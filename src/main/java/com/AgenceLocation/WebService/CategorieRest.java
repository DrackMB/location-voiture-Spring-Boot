/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.CategorieService;
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
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("agencelocation/categorie")
public class CategorieRest {

    @Autowired
    private CategorieService categorieService;

    @PostMapping("/")
    public int save(@RequestBody Marque marque, List<Categorie> categories) {
       return categorieService.save(marque, categories);
      
    }

    @GetMapping("/find")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @GetMapping("/libelle/{libelle}")
    public Categorie findByLibelle(@PathVariable String libelle) {
        return categorieService.findByLibelle(libelle);
    }
}
