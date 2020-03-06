/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Categorie;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CategorieService {
    int save(Categorie categorie);
    List<Categorie>findAll();
    Categorie findByLibelle(String libelle);
    
}
