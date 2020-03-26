/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.Repository;
import com.AgenceLocation.bean.Review;
import java.util.List;

/**
 *
 * @author aaoub
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("DELETE from Review r where r.id=:id")
    int deleteId(@Param(value = "id") Long id);

    public Review findByClientCinAndVoitureMatricule(String cin, String Matricule);

    public List<Review> findByVoitureCategorieLibelle(String libelle);

}
