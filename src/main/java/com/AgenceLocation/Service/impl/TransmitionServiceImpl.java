/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Service.facad.*;
import com.AgenceLocation.Repository.*;
import com.AgenceLocation.bean.Transmition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmitionServiceImpl implements TransmitionService {

    @Autowired
    TransmitionRepository transmitionRepository;

    public int save(Transmition transmition) {
         Transmition foundedTransmition=findByLibelle(transmition.getLibelle());
        if(foundedTransmition!=null){
            return -1;
        }else{
            transmitionRepository.save(transmition);
        
             return 1;
        }
       
    }

    @Override
    public Transmition findByLibelle(String libelle) {
        return transmitionRepository.findByLibelle(libelle);
    }

}
