/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Client;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author aaoub
 */
public interface ClientService {
    public Client findByCin(String cin);
    public List<Client> findAll();
    public void save(Client client);
    
    
}
