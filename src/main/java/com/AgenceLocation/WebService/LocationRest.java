/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.LocationService;
import com.AgenceLocation.bean.Location;
import java.util.Date;
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
@RequestMapping("AgenceLoation/Location")
public class LocationRest {

    @Autowired
    private LocationService location;

    @PostMapping("/")
    public int save(@RequestBody Location location) {
        return this.location.save(location);
    }
    @GetMapping("/datelocation/{dateLocation}/cin/{cin}")
    public Location findByDateLocationAndClientCin(@PathVariable Date dateLocation,@PathVariable String cin) {
        return location.findByDateLocationAndClientCin(dateLocation, cin);
    }
    @DeleteMapping("/")
    public int deleteBylocation(@RequestBody Location location) {
        return this.location.deleteBylocation(location);
    }
    @GetMapping("/cin/{Cin}")
    public List<Location> findByClientCin(String Cin) {
        return location.findByClientCin(Cin);
    }

}
