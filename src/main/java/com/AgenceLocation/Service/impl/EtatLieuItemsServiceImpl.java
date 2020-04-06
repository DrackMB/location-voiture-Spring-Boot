/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.EtatLieuItemsRepository;
import com.AgenceLocation.Service.facad.EtatLieuItemsService;
import com.AgenceLocation.bean.EtatLieuItems;
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

public class EtatLieuItemsServiceImpl implements EtatLieuItemsService {

    @Autowired
    private EtatLieuItemsRepository etatLieuItemsRepository;

    @Override
    public List<EtatLieuItems> findBygravite(String gravite) {

        return etatLieuItemsRepository.findByGravite(gravite);
    }

    @Override
    @Transactional
    public int deleteByGravite(String gravite) {

        return etatLieuItemsRepository.deleteByGravite(gravite);
    }

    @Override
    public List<EtatLieuItems> findAll() {
        return etatLieuItemsRepository.findAll();
    }

    @Override
    public int save(EtatLieuItems etatLieuItems) throws InstanceAlreadyExistsException {

        if (etatLieuItemsRepository.findByGraviteAndConsigne(etatLieuItems.getGravite(), etatLieuItems.getConsigne()) == null) {
            etatLieuItemsRepository.save(etatLieuItems);
            return 1;
        }
        throw new InstanceAlreadyExistsException("already exist");

    }
}
