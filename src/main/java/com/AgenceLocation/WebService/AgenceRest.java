/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.AgenceService;
import com.AgenceLocation.bean.Agence;
import com.AgenceLocation.bean.Ville;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author OuMaima
 */
@RestController
@RequestMapping("agenceLocation/agence")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AgenceRest {

    @Autowired
    private AgenceService agenceService;

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable("code") String  code) {
        return agenceService.deleteByCode(code);
    }

    @GetMapping("/nom/{nom}")
    public List<Agence> findByNom(@PathVariable("nom") String nom) {
        return agenceService.findByNom(nom);
    }

    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable("nom") String nom) {
        return agenceService.deleteByNom(nom);
    }

    @PostMapping("/")
    public int save(@RequestBody Agence agence) {
        try {
            return agenceService.save(agence);
        } catch (InstanceAlreadyExistsException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }
    }

    @GetMapping("/")
    public List<Agence> findAll() {
        return agenceService.findAll();
    }

    @GetMapping("ville/nom/{nom}")
    public List<Agence> findByVille(@PathVariable("nom") String nom) {
        return agenceService.findByVille(nom);
    }

    @GetMapping("/code/{code}")
    public Agence findByCode(@PathVariable("code") String  code) {
        return agenceService.findByCode(code);
    }

    @PutMapping("/nom/{nom}/adress/{adress}/numTele/{numTele}/code/{code}/nvCode/{nvCode}/ville/{ville}/")
    public int updateAgence(@PathVariable String nom, @PathVariable String adress, @PathVariable Long numTele, @PathVariable String  code, @PathVariable String  nvCode, @PathVariable Ville ville) {
        return agenceService.updateAgence(nom, adress, numTele, code, nvCode, ville);
    }

}
