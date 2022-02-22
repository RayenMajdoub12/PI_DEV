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
     private int idevent ;
    private String nom;
    private int prix;
    private String lieu;
    private String datedebut;
    private String datefin;
    private String description;
    

    public Evenements(int idevent, String nom, int prix, String lieu, String datedebut, String datefin, String description) {
        this.idevent = idevent;
        this.nom = nom;
        this.prix = prix;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
    }


    public Evenements() {
    }
public Evenements( String nom, int prix, String lieu, String datedebut, String datefin, String description) {
       
        this.nom = nom;
        this.prix = prix;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
    }
    public int getidevent() {
        return idevent;
    }

    public void setidevent(int id) {
        this.idevent = idevent;
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

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
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
        return "Evenements{" + "idevent=" + idevent + ", nom=" + nom + ", prix=" + prix + ", lieu=" + lieu + ", datedebut=" + datedebut + ", datefin=" + datefin + ", description=" + description + '}';
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
        if (this.idevent != other.idevent) {
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
