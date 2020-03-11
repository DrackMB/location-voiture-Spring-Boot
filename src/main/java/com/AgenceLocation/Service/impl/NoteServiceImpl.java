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
    public Note FindByLibelle(String libelle) {
       return noteRepository.findByLibelle(libelle);
    }

    @Override
    public int save(Note note) {
        Note foundedNote=noteRepository.findByLibelle(note.getLibelle());
        String foundedlibelle=foundedNote.getLibelle();
          if (foundedNote!=null) {
              return -1;}
              else if(note.getLibelle()==null){
               return -2;
             }else if(note.getLibelle()==foundedlibelle){
                          return -3;
                      }
              else {
                  noteRepository.save(note);
                  return 1;
              }   }

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

