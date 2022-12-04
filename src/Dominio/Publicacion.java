/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */

@Entity
@Table (name="publicaciones")
public class Publicacion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column (name="id_publicacion",length=11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "publicacion")
    private List<Comentario> comentarios;
    
    @Column (name="mensaje",nullable=false,length=45)
    private String mensaje;
    
    @Column (name="imagen",nullable=true,length=45)
    private String imagen;

    @JsonIgnoreProperties("publicaciones")
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "publicacion_etiqueta",
            joinColumns = {@JoinColumn(name = "id_publicacion")},
            inverseJoinColumns = {@JoinColumn(name = "id_etiqueta")}
    )
    private List<Etiqueta> etiquetas;
    
    @Column (name="fechaHora",nullable=false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar fechaHora;
    
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioEtiquetado> usuariosEtiquetados;

    public Publicacion() {
    }

    public Publicacion(Long id) {
        this.id = id;
    }

    public Publicacion(Long id, Usuario usuario, List<Comentario> comentarios, String mensaje, String imagen, List<Etiqueta> etiquetas, Calendar fechaHora, List<UsuarioEtiquetado> usuariosEtiquetados) {
        this.id = id;
        this.usuario = usuario;
        this.comentarios = comentarios;
        this.mensaje = mensaje;
        this.imagen = imagen;
        this.etiquetas = etiquetas;
        this.fechaHora = fechaHora;
        this.usuariosEtiquetados = usuariosEtiquetados;
    }

    public Publicacion(Usuario usuario, List<Comentario> comentarios, String mensaje, String imagen, List<Etiqueta> etiquetas, Calendar fechaHora, List<UsuarioEtiquetado> usuariosEtiquetados) {
        this.usuario = usuario;
        this.comentarios = comentarios;
        this.mensaje = mensaje;
        this.imagen = imagen;
        this.etiquetas = etiquetas;
        this.fechaHora = fechaHora;
        this.usuariosEtiquetados = usuariosEtiquetados;
    }

    public Publicacion(Usuario usuario, String mensaje, String imagen, List<Etiqueta> etiquetas, Calendar fechaHora, List<UsuarioEtiquetado> usuariosEtiquetados) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.imagen = imagen;
        this.etiquetas = etiquetas;
        this.fechaHora = fechaHora;
        this.usuariosEtiquetados = usuariosEtiquetados;
    }
    
    public Publicacion(Usuario usuario, String mensaje, List<Etiqueta> etiquetas, Calendar fechaHora, List<UsuarioEtiquetado> usuariosEtiquetados) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
        this.fechaHora = fechaHora;
        this.usuariosEtiquetados = usuariosEtiquetados;
    }

    public Publicacion(Usuario usuario, String mensaje, Calendar fechaHora) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
    }

    public Publicacion(Long id, Usuario usuario, String mensaje, List<Etiqueta> etiquetas, Calendar fechaHora) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
        this.fechaHora = fechaHora;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<UsuarioEtiquetado> getUsuariosEtiquetados() {
        return usuariosEtiquetados;
    }

    public void setUsuariosEtiquetados(List<UsuarioEtiquetado> usuariosEtiquetados) {
        this.usuariosEtiquetados = usuariosEtiquetados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Publicacion other = (Publicacion) obj;
        return Objects.equals(this.id, other.id);
    }
    
    

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", usuario=" + usuario + ", comentarios=" + comentarios + ", mensaje=" + mensaje + ", imagen=" + imagen + ", etiquetas=" + etiquetas + ", fechaHora=" + fechaHora + ", usuariosEtiquetados=" + usuariosEtiquetados + '}';
    }

    
    
}

