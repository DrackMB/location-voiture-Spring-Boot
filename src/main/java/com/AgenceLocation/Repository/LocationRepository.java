/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Location;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByDateLocationAndClientCin(Date dateLocation, String cin);

  //  int deleteBylocationClientCin(String cin);
    
    List<Location> findByClientCin(String Cin);
   

}
