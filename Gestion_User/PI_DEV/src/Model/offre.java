/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class offre {
    private int id_offre ;
    private String nom_o;
    private String datedebut_o;
    private String datefin_o;
    private String descr_off;   

    public offre(int id_offre, String nom_o, String datedebut_o, String datefin_o, String descr_off) {
        this.id_offre = id_offre;
        this.nom_o = nom_o;
        this.datedebut_o = datedebut_o;
        this.datefin_o = datefin_o;
        this.descr_off = descr_off;
        
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getNom_o() {
        return nom_o;
    }

    public void setNom_o(String nom_o) {
        this.nom_o = nom_o;
    }

    public String getDatedebut_o() {
        return datedebut_o;
    }

    public void setDatedebut_o(String datedebut_o) {
        this.datedebut_o = datedebut_o;
    }

    public String getDatefin_o() {
        return datefin_o;
    }

    public void setDatefin_o(String datefin_o) {
        this.datefin_o = datefin_o;
    }

    public String getDescr_off() {
        return descr_off;
    }

    public void setDescr_off(String descr_off) {
        this.descr_off = descr_off;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final offre other = (offre) obj;
        if (this.id_offre != other.id_offre) {
            return false;
        }
        if (!Objects.equals(this.nom_o, other.nom_o)) {
            return false;
        }
        if (!Objects.equals(this.descr_off, other.descr_off)) {
            return false;
        }
        if (!Objects.equals(this.datedebut_o, other.datedebut_o)) {
            return false;
        }
        if (!Objects.equals(this.datefin_o, other.datefin_o)) {
            return false;
        }
        return true;
    }

  
        
    

}

  
    
   