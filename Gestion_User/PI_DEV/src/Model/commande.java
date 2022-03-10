package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class commande {
       private int réf_c;
    private int id_a;
    private String date_c;
    private String nom_e;

    public String getNom_e() {
        return nom_e;
    }

    public void setNom_e(String nom_e) {
        this.nom_e = nom_e;
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
        final commande other = (commande) obj;
        if (this.réf_c != other.réf_c) {
            return false;
        }
        if (this.id_a != other.id_a) {
            return false;
        }
        if (this.nom_e != other.nom_e) {
            return false;
        }
        if (!Objects.equals(this.date_c, other.date_c)) {
            return false;
        }
        return true;
    }

    public int getRéf_c() {
        return réf_c;
    }

    public void setRéf_c(int réf_c) {
        this.réf_c = réf_c;
    }

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getDate_c() {
        return date_c;
    }

    public void setDate_c(String date_c) {
        this.date_c = date_c;
    }

    public commande(int réf_c, int id_a, String date_c,String nom_e) {
        this.réf_c = réf_c;
        this.id_a = id_a;
        this.date_c = date_c;
         this.nom_e = nom_e;
    }
}
