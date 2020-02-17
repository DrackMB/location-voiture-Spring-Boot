/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.facad;

import com.AgenceLocation.bean.Note;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author aaoub
 */
@Service
public interface NoteService {
    public List<Note> findAll(); 
    public void save(Note note);
    public Note FindByLibelle(String libelle);
}
