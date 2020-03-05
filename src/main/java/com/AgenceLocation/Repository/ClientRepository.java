/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;
import com.AgenceLocation.bean.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author aaoub
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
  public Client findByCin(String cin);
  
  
    
}
