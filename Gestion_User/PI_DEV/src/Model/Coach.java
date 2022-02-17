/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rayen
 */
public class Coach extends Login {
    private int id_coach ;
    private  String nom ;
    private  String prenom ;
    private  String email ;
    private  String specialite ;
    private  int telephone ;

    public Coach() {
    }

    public Coach(int id_coach, String nom, String prenom, String email, String specialite, int telephone, int id_login, String pseudo, String mdp, String role) {
        super(id_login, pseudo, mdp, role);
        this.id_coach = id_coach;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.telephone = telephone;
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialité(String specialite) {
        this.specialite = specialite;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Coach{" + "id_coach=" + id_coach + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", specialite=" + specialite + ", telephone=" + telephone + '}';
    }

 
     
}
