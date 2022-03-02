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
    private int idpart ;
    private int idevent;
    private int iduser;
    private int prix;
    private int numpart;
    private String categoriepart;
    private String description;

       //const
    public Participations(int idpart, int idevent, int iduser, int prix, int numpart, String categoriepart, String description) {
        this.idpart = idpart;
        this.idevent = idevent;
        this.iduser = iduser;
        this.prix = prix;
        this.numpart = numpart;
        this.categoriepart = categoriepart;
        this.description = description;
    }

    public Participations() {
    }
   
    //Auto inc
    public Participations( int idevent, int iduser, int prix, int numpart, String categoriepart, String description) {
        
        this.idevent = idevent;
        this.iduser = iduser;
        this.prix = prix;
        this.numpart = numpart;
        this.categoriepart = categoriepart;
        this.description = description;
    }
    // getter and setter 

    public int getIdpart() {
        return idpart;
    }

    public void setIdpart(int idpart) {
        this.idpart = idpart;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNumpart() {
        return numpart;
    }

    public void setNumpart(int numpart) {
        this.numpart = numpart;
    }

    public String getCategoriepart() {
        return categoriepart;
    }

    public void setCategoriepart(String categoriepart) {
        this.categoriepart = categoriepart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Participations{" + "idpart=" + idpart + ", idevent=" + idevent + ", iduser=" + iduser + ", prix=" + prix + ", numpart=" + numpart + ", categoriepart=" + categoriepart + ", description=" + description + '}';
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
        if (this.idpart != other.idpart) {
            return false;
        }
        if (this.idevent != other.idevent) {
            return false;
        }
        if (this.iduser != other.iduser) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (this.numpart != other.numpart) {
            return false;
        }
        if (!Objects.equals(this.categoriepart, other.categoriepart)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
