/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Categorie;
import com.AgenceLocation.bean.Marque;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CategorieService {
    int save(Marque marque, List<Categorie> categories);
    List<Categorie>findAll();
    Categorie findByLibelle(String libelle);
    

  
    
}
