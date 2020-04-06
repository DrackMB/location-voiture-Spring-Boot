/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.ConsigneRepository;
import com.AgenceLocation.Service.facad.ConsigneService;
import com.AgenceLocation.bean.Consigne;
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
public class ConsigneServiceImpl implements ConsigneService {

    @Autowired
    private ConsigneRepository consigneRepository;

    @Override
    public int save(Consigne consigne) throws InstanceAlreadyExistsException {
        Consigne foundedConsigne = findByLibelle(consigne.getLibelle());

        if (foundedConsigne == null) {
            consigneRepository.save(consigne);
            return 1;
        }
        throw new InstanceAlreadyExistsException("exixte deja");
    }

    @Override
    public List<Consigne> findAll() {
        return consigneRepository.findAll();
    }

    @Override
    public Consigne findByLibelle(String libelle) {

        return consigneRepository.findByLibelle(libelle);
    }

    @Override
    public List<Consigne> findByEtatLieuReference(String reference) {

        return consigneRepository.findByEtatLieuReference(reference);

    }

    @Override
    @Transactional
    public int deleteByLibelle(String Libelle) {
        Consigne foundedConsigne = findByLibelle(Libelle);
        if (foundedConsigne != null) {

            return consigneRepository.deleteByLibelle(Libelle);
        }
        return -1;

    }


}
