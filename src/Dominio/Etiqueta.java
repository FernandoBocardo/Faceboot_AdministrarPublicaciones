/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table (name="etiquetas")
public class Etiqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column (name="id_etiqueta",length=11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="nombreEtiqueta",nullable=false,length=45)
    private String nombreEtiqueta;
    
    @ManyToMany(mappedBy = "etiquetas")
    private List<Publicacion> publicaciones;

    public Etiqueta() {
    }

    public Etiqueta(Long id) {
        this.id = id;
    }

    public Etiqueta(Long id, String nombreEtiqueta, List<Publicacion> publicaciones) {
        this.id = id;
        this.nombreEtiqueta = nombreEtiqueta;
        this.publicaciones = publicaciones;
    }

    public Etiqueta(String nombreEtiqueta, List<Publicacion> publicaciones) {
        this.nombreEtiqueta = nombreEtiqueta;
        this.publicaciones = publicaciones;
    }

    public Etiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etiqueta)) {
            return false;
        }
        Etiqueta other = (Etiqueta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etiqueta{" + "id=" + id + ", nombreEtiqueta=" + nombreEtiqueta + ", publicaciones=" + publicaciones + '}';
    }      
    
}
