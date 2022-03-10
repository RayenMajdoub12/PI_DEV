/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 23yas
 */

public class Programme {
    
    int id;
    private String title;
    private String categorie;
    private String description;
    
    
    public Programme(){
    }

    public Programme(int id, String title, String categorie, String description) {
        this.id = id;
        this.title = title;
        this.categorie = categorie;
        this.description = description;
    }

    public Programme(String title, String categorie,String description) {
        this.title = title;
        this.categorie = categorie;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
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
        final Programme other = (Programme) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Programme{" + "id=" + id + ", title=" + title + ", categorie=" + categorie + ", description=" + description + '}';
    }

    
    
    
    
    
}
