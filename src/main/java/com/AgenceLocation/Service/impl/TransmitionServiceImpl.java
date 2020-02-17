/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.TransmitionRepository;
import com.AgenceLocation.Service.facad.TransmitionService;
import com.AgenceLocation.bean.Transmition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class TransmitionServiceImpl implements TransmitionService {
    @Autowired
    private TransmitionRepository transmitionRepository;

    @Override
    public void save(Transmition transmition) {
        transmitionRepository.save(transmition);
    }

}
