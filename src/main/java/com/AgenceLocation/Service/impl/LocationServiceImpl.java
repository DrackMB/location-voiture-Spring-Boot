/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.LocationRepository;
import com.AgenceLocation.Service.facad.LocationDetailService;
import com.AgenceLocation.Service.facad.LocationService;
import com.AgenceLocation.bean.Location;
import com.AgenceLocation.bean.LocationDetail;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationDetailService locationDetailService;

    @Override
    public int save(Location location) {

        List<LocationDetail> locationDetails = locationDetailService.findByLocationClientCin(location.getClient().getCin());
        Location locationResult = findByDateLocationAndClientCin(location.getDateLocation(), location.getClient().getCin());
        if (!locationDetails.isEmpty()) {
            if (locationResult == null) {
                locationRepository.save(location);
                return 1;
            }
            return -1;
        }
        return -2;
    }

    @Override
    public Location findByDateLocationAndClientCin(Date dateLocation, String cin) {
        return locationRepository.findByDateLocationAndClientCin(dateLocation, cin);
    }

    @Transactional
    @Override
    public int deleteBylocation(Location location) {
                int s1=0,s2=0;        
       int result =verifier(location);
       if(result>0){
            List<LocationDetail> locationDetails = locationDetailService.findByLocation(location);
        for (LocationDetail locationDetail : locationDetails) {
          s1+=locationDetailService.deleteByLocationClientCinAndVoitureMatricule(locationDetail.getLocation().getClient().getCin()
                  , locationDetail.getVoiture().getMatricule());
        }
        locationRepository.delete(location);
        return s1;
       }
     return -1;
       
        }

    

    @Override
    public List<Location> findByClientCin(String Cin) {
        return locationRepository.findByClientCin(Cin);
    }
    
    private  int verifier(Location location){
        List<Location> locations = findByClientCin(location.getClient().getCin());
        for (Location locationresult : locations) {
            if(location.equals(locationresult)){
                return 1;
            }
        }
        return -1;
    }

}
