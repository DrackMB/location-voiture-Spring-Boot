/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.EtatLieuRepository;
import com.AgenceLocation.Service.facad.EtatLieuService;
import com.AgenceLocation.bean.EtatLieu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OuMaima
 */
@Service
public class EtatLieuServiceImpl implements EtatLieuService {

    @Autowired
    private EtatLieuRepository etatLieuRepository;

    @Override
    public List<EtatLieu> findAll() {

        return etatLieuRepository.findAll();
    }

    @Override
    public int save(EtatLieu etatLieu)throws InstanceAlreadyExistsException {

        EtatLieu e = findByReference(etatLieu.getReference());
        if (e == null) {
            etatLieuRepository.save(etatLieu);
            return 1;
        }
            
        throw new InstanceAlreadyExistsException("exist");
       
    }

    @Override
    public EtatLieu findByReference(String reference) {
        
        return etatLieuRepository.findByReference(reference);
    }

    @Override
    public List<EtatLieu> findByDateEtatLieu(Date dateEtatLieu) {
        return etatLieuRepository.findByDateEtatLieu(dateEtatLieu);

//   List<EtatLieu> res = new ArrayList();
//        List<EtatLieu> ET = findAll();
//        for (EtatLieu e : ET) {
//            if (dateEtatLieu.equals(e.getDateEtatLieu())) {
//                res.add(e);
//
//            }
//
//        }
//        return res;
    }

    @Override
    public List<EtatLieu> findByLocationDetailDateLocation(Date date) {

        return etatLieuRepository.findByLocationDetail_DateLocation(date);

    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
       
        EtatLieu foundeds = findByReference(reference);
        if (foundeds != null) {
            etatLieuRepository.deleteByReference(reference);
            return 1;
        }
        return -1;
    }

    


    @Override
    public List<EtatLieu> findByLocationDetailDateRetour(Date date) {

    
     return etatLieuRepository.findByLocationDetail_DateRetour(date);
    }

    

    @Override
    public List<EtatLieu> findByLocationDetailLocationClientCin(String cin) {
       
        return etatLieuRepository.findByLocationDetail_Location_Client_Cin(cin);

    }

    @Override
    @Transactional
    public int deleteByLocationDetailLocationClientCin(String cin) {
        
        List<EtatLieu> ET = findByLocationDetailLocationClientCin(cin);
        if (ET != null) {

            return etatLieuRepository.deleteByLocationDetail_Location_Client_Cin(cin);
        }
        return -1;

    }

    @Override
    public List<EtatLieu> findByLocationDetailPrix(Double prix) {

        return etatLieuRepository.findByLocationDetail_Prix(prix);

    }

    @Override
    public List<EtatLieu> findByLocationDetailVoitureMatricule(String matricule) {
       
        return etatLieuRepository.findByLocationDetail_Voiture_Matricule(matricule);

    }

    @Override
    @Transactional
    public int deleteByLocationDetailVoitureMatricule(String matricule) {
        
      
        List<EtatLieu> foundeds = findByLocationDetailVoitureMatricule(matricule);
        if (foundeds.size() > 0) {
            return etatLieuRepository.deleteByLocationDetail_Voiture_Matricule(matricule);
        }

        return 0;

    }

    
}
