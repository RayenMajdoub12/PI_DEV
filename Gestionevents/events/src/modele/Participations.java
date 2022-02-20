/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;

/**
 *
 * @author Mohamed
 */
public class Participations {
  private int id ;
    private String event;
    private int prix;
    private String categorie;
    private int numpts;

    public Participations() {
    }

    public Participations(int id, String event, int prix, String categorie, int numpts) {
        this.id = id;
        this.event = event;
        this.prix = prix;
        this.categorie = categorie;
        this.numpts = numpts;
    }
    
     public Participations( String event, int prix, String categorie, int numpts) {
        
        this.event = event;
        this.prix = prix;
        this.categorie = categorie;
        this.numpts = numpts;
    }
     
     //GETTER AND SETTER 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNumpts() {
        return numpts;
    }

    public void setNumpts(int numpts) {
        this.numpts = numpts;
    }

    @Override
    public String toString() {
        return "Participations{" + "id=" + id + ", event=" + event + ", prix=" + prix + ", categorie=" + categorie + ", numpts=" + numpts + '}';
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
        final Participations other = (Participations) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (this.numpts != other.numpts) {
            return false;
        }
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        return true;
    }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
