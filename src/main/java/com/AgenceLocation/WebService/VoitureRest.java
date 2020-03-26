
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.VoitureService;
import com.AgenceLocation.bean.Voiture;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@CrossOrigin(origins = {"http://localhost:4200"})
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
    
    @GetMapping("/libelle/{libelle}/code/{code}")
    public Voiture findByCategorielibelle (@PathVariable String libelle,@PathVariable String code){
        return voitureService.findByCategorielibelle(libelle,code);
        
    }
    @GetMapping("Trans/libelle/{libelle}")
    public List<Voiture> findByTransmitionLibelle(@PathVariable String libelle) {
        return voitureService.findByTransmitionLibelle(libelle);
    }
    
    @GetMapping("Carb/libelle/{libelle}")
    public List<Voiture> findByCarburantLibelle(@PathVariable String libelle) {
        return voitureService.findByCarburantLibelle(libelle);
    }
    
    @GetMapping("Catgagc/libelle/{libelle}/nom/{nom}")
    public Voiture findByCategorieLibelleAndAgenceNom(@PathVariable String libelle, @PathVariable String nom){
        return voitureService.findByCategorieLibelleAndAgenceNom(libelle, nom);
    }
    
    @DeleteMapping("voit/matricule/{matricule}")
    public int deleteByMatricule(@PathVariable String matricule){
        return voitureService.deleteByMatricule(matricule);
    }

    @PutMapping("voiture/matricule/{matricule}/moyenNote/{moyenNote}/prixinitial/{prixinitial}")
    public int updateVoiture(@PathVariable String matricule,@PathVariable double moyenNote,@PathVariable int prixinitial) {
        return voitureService.updateVoiture(matricule, moyenNote, prixinitial);
    }

    
    
    
    @GetMapping("/findBylibelle/{libelle}")
    public Voiture findByCategorieLibelle(@PathVariable String libelle) {
        return voitureService.findByCategorieLibelle(libelle);
    }

}

