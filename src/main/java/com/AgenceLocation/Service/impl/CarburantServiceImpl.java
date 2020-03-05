/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;


import com.AgenceLocation.Repository.CarburantRepository;
import com.AgenceLocation.Service.facad.CarburantService;
import com.AgenceLocation.bean.Carburant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author dell
 */
@Service
public class CarburantServiceImpl implements CarburantService{
    @Autowired
    CarburantRepository carburantRepository;
    
    public int save(Carburant carburant){
         carburantRepository.save(carburant);
        return 1;
    }
    
}
