/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.WebService;

import com.AgenceLocation.Service.facad.NoteService;
import com.AgenceLocation.bean.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aaoub
 */
@RestController
@RequestMapping("AgenceLocation/note")
public class NoteRest {
     @Autowired
     NoteService noteService;
     
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return noteService.deleteByLibelle(libelle);
    }
    
    @PostMapping("/")
    public int save(@RequestBody Note note) {
        return noteService.save(note);
    }
    @GetMapping("/libelle/{libelle}")
    public Note findByLibelle(@PathVariable String libelle) {
        return noteService.findByLibelle(libelle);
    }
    
   
    @GetMapping("/fin/") 
     public List<Note> findAll() {
        return noteService.findAll();
    }
  
    
}
