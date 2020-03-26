/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Location;
import com.AgenceLocation.bean.LocationDetail;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface LocationDetailRepository extends JpaRepository<LocationDetail,Long>{
    
     @Query("select l from LocationDetail l where l.voiture.id=:idVoiture AND l.dateLocation>=:date AND l.dateRetour<=:date")
    List<LocationDetail> findByVoitureAndDate(@Param("idVoiture")Long id,@Param("date")Date date);
    
    List<LocationDetail> findByLocationClientCinAndVoitureMatricule(String Cin,String matricule);
    
    int deleteByLocationClientCinAndVoitureMatricule(String cin , String matricule);
    
    List<LocationDetail> findByLocationClientCin(String cin);
    
    List<LocationDetail> findByLocation(Location location);
    
    
    
    
}
