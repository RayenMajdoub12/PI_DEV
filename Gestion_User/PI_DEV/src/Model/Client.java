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
public class Client  {
    private int id_user;
    private String nom ;
    private String prenom;
    private String email ;
    private String pseudo ;
    private String mdp ;
    private int tel ;
    private int age ;
    private String role ;

    public Client() {
    }

    //constructeur param
    public Client(int id_user, String nom, String prenom, String email, String pseudo, String mdp, int tel, int age, String role) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.tel = tel;
        this.age = age;
        this.role = role;
    }
    //constructeur param sans id_user
      public Client( String nom, String prenom, String email, String pseudo, String mdp, int tel, int age, String role) {
     
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.tel = tel;
        this.age = age;
        this.role = role;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        final Client other = (Client) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pseudo=" + pseudo + ", mdp=" + mdp + ", tel=" + tel + ", age=" + age + ", role=" + role + '}';
    }

   
    
    }






    
    
    

