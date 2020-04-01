/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.EtatLieuItemsService;
import com.AgenceLocation.bean.EtatLieuItems;
import java.util.List;
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
@RequestMapping("/AgenceLocation/etatLieuItems")
@CrossOrigin(origins = "htpp://localhost:4200/")
public class EtatLieuItemsRest {
    
    @Autowired
    private EtatLieuItemsService etatLieuItemsService;

    @GetMapping("/gravite/{gravite}")
    public List<EtatLieuItems> findBygravite(@PathVariable("gravite") String gravite) {
        return etatLieuItemsService.findBygravite(gravite);
    }

    @DeleteMapping("/gravite/{gravite}")
    public int deleteByGravite(@PathVariable("gravite") String gravite) {
        return etatLieuItemsService.deleteByGravite(gravite);
    }

     @GetMapping
    public List<EtatLieuItems> findAll() {
        return etatLieuItemsService.findAll();
    }

    @PostMapping
    public int save(@RequestBody EtatLieuItems etatLieuItems){
        try {
            return etatLieuItemsService.save(etatLieuItems);
        } catch (InstanceAlreadyExistsException ex) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage() , ex);
        }
    }
    
    
    
    
}
