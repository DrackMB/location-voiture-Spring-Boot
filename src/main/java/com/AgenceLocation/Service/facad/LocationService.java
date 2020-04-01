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
public interface LocationService {
   int save(Location location);
   
   Location findByDateLocationAndClientCin(Date dateLocation , String cin);
   
   int deleteBylocation(Location  location);
   
   List<Location> findByClientCin(String Cin);
   
   
   
   
   
    
    
}
