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
import org.springframework.transaction.annotation.Transactional;

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
    public int save(Client client){
        Client founded=clientRepository.findByCin(client.getCin());
        if (founded!=null) {
            return -1;
        }else if(client.getCin()==null){return -2; }
        else{   clientRepository.save(client);
        return 1;
        }
    }

    @Transactional
    public int deleteByCin(String cin) {
        int result=clientRepository.deleteByCin(cin);
        return result;
    }
    
}
