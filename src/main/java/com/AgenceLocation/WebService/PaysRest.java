/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.PaysService;
import com.AgenceLocation.bean.Pays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author OuMaima
 */
@RestController
@RequestMapping ("agenceLocation/pays")
@CrossOrigin(origins = {"http://localhost:4200"})

public class PaysRest {
    @Autowired
    private PaysService paysService;

    @GetMapping("/nom/{nom}")
    public Pays findByNom(@PathVariable("nom") String nom) {
        return paysService.findByNom(nom);
    }

    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable("nom") String nom) {
        return paysService.deleteByNom(nom);
    }

    @PostMapping("/")
    public int save(@RequestBody Pays pays){
        try {
            paysService.save(pays);
              return 1;
        } catch (InstanceAlreadyExistsException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage() , ex);
        }
  
    }
    

    @GetMapping("/")
    public List<Pays> findAll() {
        return paysService.findAll();
    }
    
    
    
}
