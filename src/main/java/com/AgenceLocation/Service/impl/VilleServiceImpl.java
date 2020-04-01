/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.PaysRepository;
import com.AgenceLocation.Repository.VilleRepository;
import com.AgenceLocation.Service.facad.PaysService;
import com.AgenceLocation.Service.facad.VilleService;
import com.AgenceLocation.bean.Ville;
import java.util.List;
import javassist.NotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author OuMaima
 */
@Service
@Transactional
public class VilleServiceImpl implements VilleService {

    @Autowired
    private PaysRepository paye;
    @Autowired
    private VilleRepository villeRepository;

    @Override
    public Ville findByNom(String nom) {
        if (nom == null) {
            nom = "";
        }
        return villeRepository.findByNom(nom);
    }

    @Override
    public int deleteByNom(String nom) {

        Ville foundedVille = findByNom(nom);
        if (foundedVille != null) {

            return villeRepository.deleteByNom(nom);
        }
        return -1;
    }

    @Override
    public void save(Ville ville) throws NotFoundException, InstanceAlreadyExistsException {

        Ville foundedVille = findByNom(ville.getNom());
        if (foundedVille == null) {
            ville.setPays(paye.findByNom(ville.getPays().getNom()));
            if (ville.getPays() == null) {
                throw new NotFoundException("no pays with name");
            }
            // paye.save(ville.getPays());
            villeRepository.save(ville);

        } else {
            throw new InstanceAlreadyExistsException("exist");
        }
    }

    @Override
    public List<Ville> findAll() {
        return villeRepository.findAll();
    }

}
