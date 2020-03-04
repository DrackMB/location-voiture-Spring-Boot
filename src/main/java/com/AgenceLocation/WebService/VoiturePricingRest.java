/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;
import com.AgenceLocation.bean.Voiture;
import com.AgenceLocation.Service.facad.VoiturePricingService;
import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.VoiturePricing;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */
@RestController
@RequestMapping("/pricing/")
public class VoiturePricingRest {
    @Autowired
    VoiturePricingService voiturePricingService;

    @GetMapping("/")
    public List<VoiturePricing> findAll() {
        return voiturePricingService.findAll();
    }
    @PostMapping("/")
    public int save(Voiture voiture, int Porcentage, Date dateFinal, Date dateDebu) {
        return voiturePricingService.save(voiture, Porcentage, dateFinal, dateDebu);
    }
    @DeleteMapping("/")
    public int deleteByCategorie(Categorie categorie) {
        return voiturePricingService.deleteByCategorie(categorie);
    }
    @GetMapping("/t/")
    public List <VoiturePricing> findByCategorie(Categorie categorie) {
        return voiturePricingService.findByCategorie(categorie);
    }

    public void checkeExistancePromo() {
        voiturePricingService.checkeExistancePromo();
    }
    
    
}
