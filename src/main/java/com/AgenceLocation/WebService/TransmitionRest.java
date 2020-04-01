/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.*;
import com.AgenceLocation.Repository.*;
import com.AgenceLocation.bean.Transmition;
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
@RequestMapping("AgenceLocation/transmition")
public class TransmitionRest {

    @Autowired
    TransmitionService transmitionService;

    @PostMapping("/")
    public int save(@RequestBody Transmition transmition) {
        return transmitionService.save(transmition);
    }

     @GetMapping("/libelle/{libelle}")
    public Transmition findByLibelle(@PathVariable String libelle) {
        return transmitionService.findByLibelle(libelle);
    }
    @GetMapping("/")
    public List<Transmition> findAll() {
        return transmitionService.findAll();
    }
    
}
