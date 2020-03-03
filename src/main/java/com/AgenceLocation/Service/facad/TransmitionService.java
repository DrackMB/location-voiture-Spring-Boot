/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.Repository.*;
import com.AgenceLocation.bean.Transmition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dell
 */
public interface TransmitionService {

    int save(Transmition transmition);

}
