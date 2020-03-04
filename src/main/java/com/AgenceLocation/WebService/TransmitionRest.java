/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.*;
import com.AgenceLocation.Repository.*;
import com.AgenceLocation.bean.Transmition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */
@RestController
@RequestMapping("/transm")
public class TransmitionRest {

    @Autowired
    TransmitionService transmitionService;

    @PostMapping("/")
    public int save(Transmition transmition) {
        return transmitionService.save(transmition);
    }

}
