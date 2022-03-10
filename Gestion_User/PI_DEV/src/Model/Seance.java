/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Date;
import java.util.List;

/**
 *
 * @author 23yas
 */
public class Seance {
    private int id;
    private String nom;
    private Date date;
    private String heure;
    private String description;
    
    
    

    public Seance() {
    }

    public Seance(String nom, Date date, String heure, String description) {
        this.nom = nom;
        this.date = date;
        this.heure = heure;
        this.description = description;
        
        
    }

    public Seance(int id, String nom, Date date, String heure, String description) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.heure = heure;
        this.description = description;
        
        
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getDescription() {
        return description;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public void setDescription(String description) {
        this.description = description;
    }

    

    public void setHeure(String heure) {
        this.heure = heure;
    }

    
    
    

    

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
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
        final Seance other = (Seance) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seance{" + "id=" + id + ", nom=" + nom + ", date=" + date + ", heure=" + heure + ", description=" + description + '}';
    }

    

    

    

    

    
    
    

    
    

     
    
    
    
}
