/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.LocationDetailService;
import com.AgenceLocation.bean.LocationDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RestController
@RequestMapping("/AgenceLocation/LocationDetail")
public class LocationDetailRest {

    @Autowired
    private LocationDetailService locationDetailService;
    @PostMapping("/")
    public int save(@RequestBody LocationDetail locationDetail) {
        return locationDetailService.save(locationDetail,locationDetail.getLocation());
    }
    @GetMapping("/clientcin/{Cin}")
    public List<LocationDetail> findByLocationClientCin(@PathVariable String Cin) {
        return locationDetailService.findByLocationClientCin(Cin);
    }
    @DeleteMapping("/cin/{cin}/voiture/{matricule}")
    public int deleteByLocationClientCinAndVoitureMatricule(@PathVariable String cin,@PathVariable String matricule) {
        return locationDetailService.deleteByLocationClientCinAndVoitureMatricule(cin, matricule);
    }
    @GetMapping("/clientCin/{Cin}/matricul/{matricule}")
    public List<LocationDetail> findByLocationClientCinAndVoitureMatricule(@PathVariable String Cin,@PathVariable String matricule) {
        return locationDetailService.findByLocationClientCinAndVoitureMatricule(Cin, matricule);
    }
   
    

}
