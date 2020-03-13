/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Note;
import java.util.List;

/**
 *
 * @author aaoub
 */
public interface NoteService {

    public List<Note> findAll();

    public int save(Note note);

    public Note findByLibelle(String libelle);
    
    
    public int deleteByLibelle(String libelle) ;
    
    public int UpdateNote(String libelle,int moyen );

}
