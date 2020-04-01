/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.LocationDetailRepository;
import com.AgenceLocation.Service.facad.LocationDetailService;
import com.AgenceLocation.Service.facad.LocationService;
import com.AgenceLocation.Service.facad.VoiturePricingService;
import com.AgenceLocation.bean.Location;
import com.AgenceLocation.bean.LocationDetail;
import com.AgenceLocation.bean.VoiturePricing;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */
@Service
public class LocationDetailServiceImpl implements LocationDetailService {

    @Autowired
    private LocationDetailRepository locationdetailRepository;
    @Autowired
    private VoiturePricingService voiturePricingService;
    @Autowired
    private LocationService locationService;

    @Override
    public int save(LocationDetail locationDetail, Location location) {
        VoiturePricing voiturePricingResult = voiturePricingService.findByCategorieLibelle(locationDetail.getVoiture().getCategorie().getLibelle());
        if (voiturePricingResult != null) {
            locationDetail.setPrix(voiturePricingResult.getPrix());
            double sum = location.getPrixTotal() + voiturePricingResult.getPrix();
            location.setPrixTotal(sum);
            locationService.save(location);
            locationdetailRepository.save(locationDetail);
            return 1;
        }
        return -1;

    }

    @Override
    public List<LocationDetail> findByLocationClientCin(String Cin) {
        return locationdetailRepository.findByLocationClientCin(Cin);
    }

    @Transactional
    @Override
    public int deleteByLocationClientCinAndVoitureMatricule(String cin, String matricule) {
        return locationdetailRepository.deleteByLocationClientCinAndVoitureMatricule(cin, matricule);
    }

    @Override
    public List<LocationDetail> findByLocationClientCinAndVoitureMatricule(String Cin,String matricule) {
        return locationdetailRepository.findByLocationClientCinAndVoitureMatricule( Cin, matricule);
    }

    @Override
    public List<LocationDetail> findByLocation(Location location) {
         return locationdetailRepository.findByLocation(location);
    }

}
