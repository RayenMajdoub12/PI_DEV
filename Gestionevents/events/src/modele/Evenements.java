/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Mohamed
 */
public class Evenements {
     private int id ;
    private String nom;
    private int prix;
    private String lieu;
    private Date datedebut;
    private Date datefin;
    private String description;
    

    public Evenements(int id, String nom, int prix, String lieu, Date datedebut, Date datefin, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
    }


    public Evenements() {
    }
public Evenements( String nom, int prix, String lieu, Date datedebut, Date datefin, String description) {
       
        this.nom = nom;
        this.prix = prix;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evenements{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", lieu=" + lieu + ", datedebut=" + datedebut + ", datefin=" + datefin + ", description=" + description + '}';
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenements other = (Evenements) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.datedebut, other.datedebut)) {
            return false;
        }
        if (!Objects.equals(this.datefin, other.datefin)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    

    
    
}
