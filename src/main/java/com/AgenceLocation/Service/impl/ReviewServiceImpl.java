package com.AgenceLocation.Service.impl;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ClientService clientService;
    @Autowired
    NoteService noteService ;
   // @Autowired
    //VoitureService voiturreService;
    
   @Autowired
   ReviewRepository reviewRepository;
    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
                }

   
    public int save(Review review) {
        Client foundedClient=clientService.findByCin(review.getClient().getCin());
        Note foundedNote=noteService.FindByLibelle(review.getNote().getLibelle());
      //  Voiture foundedVoiture=voitureRepository.findByMtricule(review.getVoiture().getMatricule());
        if(foundedClient==null){
            return -1;
        }else if(foundedNote==null){
            return -2;
        }//else if(foundedVoiture==null){return -3;}  
        else{
            reviewRepository.save(review);
            return 1;
        }
        
        

    }
    
    
}
