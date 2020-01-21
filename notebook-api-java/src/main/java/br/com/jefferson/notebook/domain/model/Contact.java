//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package br.com.jefferson.notebook.domain.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("contact")
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String description;
    private String fone;
    private Integer favorite;

    public Contact(String id, String name, String description, String fone, Integer favorite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fone = fone;
        this.favorite = favorite;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Integer getFavorite() {
        return this.favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

}
