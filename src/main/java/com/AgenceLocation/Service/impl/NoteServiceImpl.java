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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aaoub
 */
@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    NoteRepository noteRepository;

    /**
     *
     * @param libelle
     * @return
     */
    public Note findByLibelle(String libelle) {
        return noteRepository.findByLibelle(libelle);
    }
    
    @Override
    public List<Note> findAll() {
       return noteRepository.findAll();
    }

    @Override
    public int save(Note note) {
        Note foundedNote=noteRepository.findByLibelle(note.getLibelle());
          if (foundedNote!=null) {
              return -1;}
              else if(note.getLibelle()==null){
               return -2;
             }
              else {
                  noteRepository.save(note);
                  return 1;
              }   }

    @Transactional
    @Override
    public int deleteByLibelle(String libelle) {
        int result=noteRepository.deleteByLibelle(libelle);
        return result;
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

