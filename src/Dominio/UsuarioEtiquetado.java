/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table (name="usuariosEtiquetados")
public class UsuarioEtiquetado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column (name="id_usuarioEtiquetado",length=11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="nombreUsuario",nullable=false,length=45)
    private String nombreUsuario;
    
    @JsonIgnoreProperties("usuariosEtiquetados")
    @ManyToMany(mappedBy = "usuariosEtiquetados")
    private List<Publicacion> publicaciones;

    public UsuarioEtiquetado() {
    }

    public UsuarioEtiquetado(Long id) {
        this.id = id;
    }

    public UsuarioEtiquetado(Long id, String nombreUsuario, List<Publicacion> publicaciones) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.publicaciones = publicaciones;
    }

    public UsuarioEtiquetado(String nombreUsuario, List<Publicacion> publicaciones) {
        this.nombreUsuario = nombreUsuario;
        this.publicaciones = publicaciones;
    }
    
    public UsuarioEtiquetado(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
        if (!(object instanceof UsuarioEtiquetado)) {
            return false;
        }
        UsuarioEtiquetado other = (UsuarioEtiquetado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioEtiquetado{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", publicaciones=" + publicaciones + '}';
    }
    
    
}
