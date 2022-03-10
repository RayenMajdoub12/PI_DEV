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
public class livraison {
    private int id_l ;

    private String date_l;
    private int réf_c;
    private String état;

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
        final livraison other = (livraison) obj;
        if (this.id_l != other.id_l) {
            return false;
        }
        
        if (this.réf_c != other.réf_c) {
            return false;
        }
        if (!Objects.equals(this.date_l, other.date_l)) {
            return false;
        }
        if (!Objects.equals(this.état, other.état)) {
            return false;
        }
        return true;
    }

    public int getId_l() {
        return id_l;
    }

    public void setId_l(int id_l) {
        this.id_l = id_l;
    }

  

    public String getDate_l() {
        return date_l;
    }

    public void setDate_l(String date_l) {
        this.date_l = date_l;
    }

    public int getRéf_c() {
        return réf_c;
    }

    public void setRéf_c(int réf_c) {
        this.réf_c = réf_c;
    }

    public String getÉtat() {
        return état;
    }

    public void setÉtat(String état) {
        this.état = état;
    }

    public livraison(int id_l, String date_l, int réf_c, String état) {
        this.id_l = id_l;
       
        this.date_l = date_l;
        this.réf_c = réf_c;
        this.état = état;
    }
}
