/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;

import com.AgenceLocation.bean.EtatLieu;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author OuMaima
 */
@Repository
public interface EtatLieuRepository extends JpaRepository<EtatLieu, Long> {

    public EtatLieu findByReference(String reference);
    
    public List<EtatLieu> findByDateEtatLieu(Date dateEtatLieu);

    public List<EtatLieu> findByLocationDetail_DateLocation( Date date);

    public int deleteByReference(String reference);

    public List<EtatLieu> findByLocationDetail_DateRetour(Date date);

    public List<EtatLieu> findByLocationDetail_Location_Client_Cin(String cin);

    public int deleteByLocationDetail_Location_Client_Cin(String cin);
   
    public List<EtatLieu> findByLocationDetail_Prix(Double prix);

    public List<EtatLieu> findByLocationDetail_Voiture_Matricule(String matricule);

    public int deleteByLocationDetail_Voiture_Matricule(String matricule);
}
