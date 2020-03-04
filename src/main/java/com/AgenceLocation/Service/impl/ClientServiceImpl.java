/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.ClientRepository;
import com.AgenceLocation.Service.facad.ClientService;
import com.AgenceLocation.bean.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aaoub
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client findByCin(String cin) {
      return clientRepository.findByCin(cin);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void save(Client client){
        Client founded=clientRepository.findByCin(client.getCin());
        if (founded==null || client.getCin()!=null ) {
            clientRepository.save(client);
        }
    }
    
}
