/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.VoiturePricingRepository;
import com.AgenceLocation.Service.facad.VoiturePricingService;
import com.AgenceLocation.bean.VoiturePricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class VoiturePricingServiceImpl implements VoiturePricingService {
    @Autowired
    private VoiturePricingRepository voiturePricingRepository;

    @Override
    public void save(VoiturePricing voiturePricing) {
        voiturePricingRepository.save(voiturePricing);
    }

}
