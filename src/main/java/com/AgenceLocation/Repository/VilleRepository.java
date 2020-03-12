/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author OuMaima
 */
@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

    public Ville findByNom(String nom);

    public int deleteByNom(String nom);
}
