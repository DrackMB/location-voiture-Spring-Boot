/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.EtatLieu;
import java.util.Date;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;

/**
 *
 * @author OuMaima
 */
public interface EtatLieuService {

    public List<EtatLieu> findAll();

    public int save(EtatLieu etatLieu)throws InstanceAlreadyExistsException;

     public EtatLieu findByReference(String reference);

    public List<EtatLieu> findByDateEtatLieu(Date dateEtatLieu);

    public List<EtatLieu> findByLocationDetailDateLocation(Date date);

    public int deleteByReference(String reference);

   



    public List<EtatLieu> findByLocationDetailDateRetour( Date date);

  

    public List<EtatLieu> findByLocationDetailLocationClientCin(String cin);

    public int deleteByLocationDetailLocationClientCin(String cin);

   
    public List<EtatLieu> findByLocationDetailPrix(Double prix);

    public List<EtatLieu> findByLocationDetailVoitureMatricule(String matricule);

    public int deleteByLocationDetailVoitureMatricule(String matricule);

}
