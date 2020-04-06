/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.VilleService;
import com.AgenceLocation.bean.Ville;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.NotFoundException;
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
@RequestMapping("agenceLocation/ville")
@CrossOrigin(origins = {"http://localhost:4200"})
public class VilleRest {
    
    @Autowired
    private VilleService villeService;
    
    @GetMapping("/nom/{nom}")
    public Ville findByNom(@PathVariable("nom") String nom) {
        return villeService.findByNom(nom);
    }

    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable("nom") String nom) {
        return villeService.deleteByNom(nom);
    }

    @PostMapping("/")
    public int save(@RequestBody Ville ville)  {
        try {
            villeService.save(ville);
            return 1;
        } catch (NotFoundException ex) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage(),ex);
        } catch (InstanceAlreadyExistsException ex) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage() , ex);
        }
    }

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }
    
    
}
