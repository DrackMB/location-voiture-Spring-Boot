/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.EtatLieuService;
import com.AgenceLocation.bean.EtatLieu;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("agenceLocation/etatLieu")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EtatLieuRest {

    @Autowired
    private EtatLieuService etatLieuService;

    @GetMapping("/")
    public List<EtatLieu> findAll() {
        return etatLieuService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody EtatLieu etatLieu) {
        try {   
            etatLieuService.save(etatLieu);
            return 1;
        } catch (InstanceAlreadyExistsException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }
    }

    @GetMapping("/reference/{reference}")
    public EtatLieu findByReference(@PathVariable("reference") String reference) {
        return etatLieuService.findByReference(reference);
    }

    @GetMapping("/dateEtatLieu/{dateLieu}")
    public List<EtatLieu> findByDateEtatLieu( @PathVariable("dateLieu") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date dateLieu) {
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date datee;
//        try {
//            datee = format.parse(dateEtatLieu);   
//         return etatLieuService.findByDateEtatLieu(datee);
//        } catch (ParseException ex){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage(),ex);
//        }
       
        
        return etatLieuService.findByDateEtatLieu(dateLieu);
        
    }

    @GetMapping("Location/date/{date}")
    public List<EtatLieu> findByLocationDetailDateLocation(@PathVariable("date") String date) {
          DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datee;
        try {
            datee = format.parse(date);   
          return etatLieuService.findByLocationDetailDateLocation(datee);
        } catch (ParseException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage(),ex);
        }
        
        
        
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable("reference") String reference) {
        return etatLieuService.deleteByReference(reference);
    }

    @GetMapping("/retour/date/{date}")
    public List<EtatLieu> findByLocationDetailDateRetour(@PathVariable("date") String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datee;
        try {
            datee = format.parse(date);   
            return etatLieuService.findByLocationDetailDateRetour(datee);
        } catch (ParseException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage(),ex);
        }
   
    }

    @GetMapping("/cin/{cin}")
    public List<EtatLieu> findByLocationDetailLocationClientCin(@PathVariable("cin") String cin) {
        return etatLieuService.findByLocationDetailLocationClientCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByLocationDetailLocationClientCin(@PathVariable("cin") String cin) {
        return etatLieuService.deleteByLocationDetailLocationClientCin(cin);
    }

    @GetMapping("/prix/{prix}")
    public List<EtatLieu> findByLocationDetailLocationPrix(@PathVariable("prix") Double prix) {
        return etatLieuService.findByLocationDetailPrix(prix);
    }

    @GetMapping("/matricule/{matricule}")
    public List<EtatLieu> findByLocationDetailVoitureMatricule(@PathVariable("matricule") String matricule) {
        return etatLieuService.findByLocationDetailVoitureMatricule(matricule);
    }

    @DeleteMapping("/matricule/{matricule}")
    public int deleteByLocationDetailVoitureMatricule(@PathVariable("matricule") String matricule) {
        return etatLieuService.deleteByLocationDetailVoitureMatricule(matricule);
    }

}
