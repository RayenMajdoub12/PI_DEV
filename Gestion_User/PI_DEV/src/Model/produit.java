/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class produit {
    private int id_p;
      private String nom_p;
    private String description_p;
    private int prix;
    private String stock;
    private String imgSrc;
    private String color;

    public produit() {
       
    }

   

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public produit(String imgSrc) {
        this.imgSrc = imgSrc;
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
        final produit other = (produit) obj;
        if (this.id_p != other.id_p) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (!Objects.equals(this.description_p, other.description_p)) {
            return false;
        }
        if (!Objects.equals(this.nom_p, other.nom_p)) {
            return false;
        }
        if (!Objects.equals(this.stock, other.stock)) {
            return false;
        }
        return true;
    }

    public produit(int id_p, String nom_p, String description_p, int prix, String stock, String imgSrc, String color) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.description_p = description_p;
        this.prix = prix;
        this.stock = stock;
        this.imgSrc = imgSrc;
        this.color = color;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getDescription_p() {
        return description_p;
    }

    public void setDescription_p(String description_p) {
        this.description_p = description_p;
    }

    public String getNom_p() {
        return nom_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

 
    
}
