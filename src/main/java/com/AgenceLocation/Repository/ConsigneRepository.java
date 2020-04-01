/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Consigne;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author OuMaima
 */
@Repository
public interface ConsigneRepository extends JpaRepository<Consigne, Long> {

    public Consigne findByLibelle(String libelle);

    int deleteByLibelle(String Libelle);

    List<Consigne> findByEtatLieuReference(String reference);

}
