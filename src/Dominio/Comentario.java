/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table (name="comentarios")
public class Comentario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column (name="id_comentario",length=11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="mensaje",nullable=false,length=45)
    private String mensaje;
    
    @Column (name="imagen",nullable=true,length=45)
    private String imagen;
    
    @ManyToOne()
    @JoinColumn(name = "id_publicacion")
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(Long id) {
        this.id = id;
    }

    public Comentario(String mensaje, Publicacion publicacion) {
        this.mensaje = mensaje;
        this.publicacion = publicacion;
    }
    
    public Comentario(String mensaje, String imagen, Publicacion publicacion) {
        this.mensaje = mensaje;
        this.imagen = imagen;
        this.publicacion = publicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Comentario other = (Comentario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", mensaje=" + mensaje + ", imagen=" + imagen + ", publicacion=" + publicacion + '}';
    }

}