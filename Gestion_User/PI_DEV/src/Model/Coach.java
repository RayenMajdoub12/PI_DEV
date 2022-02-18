/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Rayen
 */
public class Coach extends Client {

    private  String specialite ;
    private  int salaire ;

    public Coach() {
    }
//constructeur solo
    public Coach(String specialite, int salaire) {
        this.specialite = specialite;
        this.salaire = salaire;
    }
//constructeur avec id_user
    public Coach(int id_user, String nom, String prenom, String email, String pseudo, String mdp, int tel, int age, String role,String specialite, int salaire) {
        super(id_user, nom, prenom, email, pseudo, mdp, tel, age, role);
        this.specialite = specialite;
        this.salaire = salaire;
    }
//constructeur sans id_user
    public Coach( String nom, String prenom, String email, String pseudo, String mdp, int tel, int age, String role ,String specialite, int salaire) {
        super(nom, prenom, email, pseudo, mdp, tel, age, role);
        this.specialite = specialite;
        this.salaire = salaire;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
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
        final Coach other = (Coach) obj;
        if (this.salaire != other.salaire) {
            return false;
        }
        return Objects.equals(this.specialite, other.specialite);
    }

    @Override
    public String toString() {
        return "Coach{" + "specialite=" + specialite + ", salaire=" + salaire + '}';
    }

   
  
    

   
 
     
}
