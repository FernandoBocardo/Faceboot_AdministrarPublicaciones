/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Dominio.Comentario;
import Dominio.Etiqueta;
import Dominio.Publicacion;
import Dominio.Usuario;
import Dominio.UsuarioEtiquetado;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class PublicacionBuilder {
    
    private Publicacion resultado;
    
    public PublicacionBuilder()
    {
        resultado = new Publicacion();
    }
    
    public Publicacion getResultado()
    {
        return resultado;
    }
    
    public void buildUsuario(Usuario usuario)
    {
        resultado.setUsuario(usuario);
    }
    
    public void buildComentarios(List<Comentario> comentarios)
    {
        resultado.setComentarios(comentarios);
    }
    
    public void buildEtiquetas(List<Etiqueta> etiquetas)
    {
        resultado.setEtiquetas(etiquetas);
    }
    
    public void buildMensaje(String mensaje)
    {
        resultado.setMensaje(mensaje);
    }
    
    public void buildImagen(byte[] imagen)
    {
        resultado.setImagen(imagen);
    }
    
    public void buildFechaHora(Calendar fechaHora)
    {
        resultado.setFechaHora(fechaHora);
    }
    
    public void buildUsuariosEtiquetados(List<UsuarioEtiquetado> usuariosEtiquetados)
    {
        resultado.setUsuariosEtiquetados(usuariosEtiquetados);
    }
    
}
