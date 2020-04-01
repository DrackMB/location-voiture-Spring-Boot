/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.ConsigneService;
import com.AgenceLocation.bean.Consigne;
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
@RequestMapping("/AgenceLocation/consigne")
@CrossOrigin(origins = "htpp://localhost:4200/")
public class ConsigneRest {
    @Autowired
    private ConsigneService consigneService;

    @GetMapping("/reference/{reference}")
    public List<Consigne> findByEtatLieuReference(@PathVariable("reference") String reference) {
        return consigneService.findByEtatLieuReference(reference);
    }

    @PostMapping
    public int save(@RequestBody Consigne consigne)  {
        try {
            return consigneService.save(consigne);
        } catch (InstanceAlreadyExistsException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage() , ex);
        }
    }

    @GetMapping
    public List<Consigne> findAll() {
        return consigneService.findAll();
    }

    @GetMapping("/libelle/{libelle}")
    public Consigne findByLibelle(@PathVariable("libelle") String libelle) {
        return consigneService.findByLibelle(libelle);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable("libelle") String Libelle) {
        return consigneService.deleteByLibelle(Libelle);
    }

  
    
    
}
