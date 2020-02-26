/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Service.impl;

import com.AgenceLocation.Repository.NoteRepository;
import com.AgenceLocation.Service.facad.NoteService;
import com.AgenceLocation.bean.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aaoub
 */
@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    NoteRepository noteRepository;

    public Note findByLibelle(String libelle) {
        return noteRepository.findByLibelle(libelle);
    }
    
    @Override
    public List<Note> findAll() {
       return noteRepository.findAll();
    }

    @Override
    public void save(Note note) {
          Note foundedNote=noteRepository.findByLibelle(note.getLibelle());
          if (foundedNote==null || note.getLibelle()!=null ) {
            noteRepository.save(note);
        }
    }

    @Override
    public Note FindByLibelle(String libelle) {
       return noteRepository.findByLibelle(libelle);
    }
    
    
}
