/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Location;
import com.AgenceLocation.bean.LocationDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dell
 */
public interface LocationDetailService {

    int save(LocationDetail locationDetail, Location location);

    List<LocationDetail> findByLocationClientCin(String Cin);

    int deleteByLocationClientCinAndVoitureMatricule(String cin, String matricule);

    List<LocationDetail> findByLocationClientCinAndVoitureMatricule(String Cin, String matricule);
    
    List<LocationDetail> findByLocation(Location location);

    //List<LocationDetail> findbyLocation(Location location);
    // List<LocationDetail> findByVoitureAndDate(Long id,Date date);
}
