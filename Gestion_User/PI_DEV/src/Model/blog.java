package Model;

/**
 *
 * @author Molka
 */



public class blog {
  private int id_blog;
    private String titre ;
    private String description ;
    private String  contenu; 
    private String image_b;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    private String color;
public blog(){}

    public blog(int id_blog, String titre, String description, String contenu, String image_b) {
        this.id_blog = id_blog;
        this.titre = titre;
        this.description = description;
        this.contenu = contenu;
        this.image_b= image_b;
    }

    public String getImage_b() {
        return image_b;
    }

    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }

    public int getId_blog() {
        return id_blog;
    }

    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "blog{" + "id_blog=" + id_blog + ", titre=" + titre + ", description=" + description + ", contenu=" + contenu + ", image_b=" + image_b + '}';
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
        final blog other = (blog) obj;
        if (this.id_blog != other.id_blog) {
            return false;
        }
        return true;
    }
    
}

