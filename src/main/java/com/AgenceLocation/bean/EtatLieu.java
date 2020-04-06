/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AgenceLocation.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author OuMaima
 */
@Entity
public class EtatLieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    
    @Temporal(TemporalType.DATE)
    
    private Date dateEtatLieu;
    @OneToOne
    @JsonIgnore
    private LocationDetail locationDetail;
    private String description;

   
    @OneToMany(mappedBy = "etatLieu")
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Consigne> consigne;

    
    @OneToMany(mappedBy = "etatLieu")
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EtatLieuItems> etatLieuTtems;

    public Date getDateEtatLieu() {
        return dateEtatLieu;
    }

    public void setDateEtatLieu(Date dateEtatLieu) {
        this.dateEtatLieu = dateEtatLieu;
    }

    public List<EtatLieuItems> getEtatLieuTtems() {
        return etatLieuTtems;
    }

    public void setEtatLieuTtems(List<EtatLieuItems> EtatLieuTtems) {
        this.etatLieuTtems = EtatLieuTtems;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocationDetail getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(LocationDetail locationDetail) {
        this.locationDetail = locationDetail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description.replace("\"", "\\\"");

        //****
        this.description = description;
    }

    public List<Consigne> getConsigne() {
        return consigne;
    }

    public void setConsigne(List<Consigne> consigne) {
        this.consigne = consigne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtatLieu)) {
            return false;
        }
        EtatLieu other = (EtatLieu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.AgenceLocation.bean.EtatLieu[ id=" + id + " ]";
    }

}
