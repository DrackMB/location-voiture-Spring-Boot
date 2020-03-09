/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;
import com.AgenceLocation.bean.Voiture;
import com.AgenceLocation.Service.facad.VoiturePricingService;
import com.AgenceLocation.bean.VoiturePricing;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
 * @author dell
 */
@RestController
@RequestMapping("/VoiturePricing/")
public class VoiturePricingRest {
    @Autowired
    VoiturePricingService voiturePricingService;

    @GetMapping("/")
    public List<VoiturePricing> findAll() {
        return voiturePricingService.findAll();
    }
    @PostMapping("/Porcentage/{Porcentage}/dateFinal/{dateFinal}/dateDebu/{dateDebu}")
    public int save(@RequestBody Voiture voiture,@PathVariable int Porcentage,@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateFinal,@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateDebu) {
        return voiturePricingService.save(voiture, Porcentage, dateFinal, dateDebu);
    }
    @Transactional
    @DeleteMapping("/CategorieLibelle/{libelle}")
    public int deleteByCategorieLibelle(@PathVariable String libelle) {
        return voiturePricingService.deleteByCategorieLibelle(libelle);
    }
    @GetMapping("categorie/liblle/{libelle}")
    public  VoiturePricing findByCategorieLibelle( @PathVariable String libelle) {
        return voiturePricingService.findByCategorieLibelle(libelle);
    }
    @PutMapping("/categorie/{libelle}/date/{dateFinal}/porcentage/{porcentage}")
    public int updateVoiturePricing(@PathVariable String libelle,@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateFinal,@PathVariable int porcentage) {
        return voiturePricingService.updateVoiturePricing(libelle, dateFinal, porcentage);
    }
    @GetMapping("/Agence/nom/{nom}")
    public List<VoiturePricing> findByAgenceNom(@PathVariable String nom) {
        return voiturePricingService.findByAgenceNom(nom);
    }
    
    // voire avec prof
    public void checkeExistancePromo() {
        voiturePricingService.checkeExistancePromo();
    }
    
    
}
