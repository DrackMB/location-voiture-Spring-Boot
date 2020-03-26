/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;


import com.AgenceLocation.Service.facad.CarburantService;
import com.AgenceLocation.bean.Carburant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author dell
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/AgenceLocation/carburant")
public class CarburantRest {
    @Autowired
    CarburantService carburantService;
    @PostMapping("/")
    public int save(@RequestBody Carburant carburant) {
        return carburantService.save(carburant);
    }
    
     @GetMapping("/libelle/{libelle}")
    public Carburant findByLibelle(@PathVariable String libelle) {
        return carburantService.findByLibelle(libelle);
    }
     @GetMapping("/")
    public List<Carburant> findAll() {
        return carburantService.findAll();
    }
    
    
}
