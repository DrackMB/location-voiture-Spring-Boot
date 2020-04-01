/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Consigne;
import com.AgenceLocation.bean.EtatLieuItems;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author OuMaima
 */
@Repository
public interface EtatLieuItemsRepository extends JpaRepository<EtatLieuItems, Long>{
    public List<EtatLieuItems> findByGravite(String gravite);
    public int deleteByGravite(String gravite);
    public EtatLieuItems findByGraviteAndConsigne(String gravite,Consigne consigne);
}
