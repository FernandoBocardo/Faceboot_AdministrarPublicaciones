/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Dominio.Comentario;
import Dominio.Publicacion;
import Dominio.Usuario;
import java.util.Calendar;

/**
 *
 * @author Fernando
 */
public class ComentarioBuilder {
    
    private Comentario resultado;
    
    public ComentarioBuilder()
    {
        resultado = new Comentario();
    }
    
    public Comentario getResultado()
    {
        return resultado;
    }
    
    public void buildUsuario(Usuario usuario)
    {
        resultado.setUsuario(usuario);
    }
    
    public void buildMensaje(String mensaje)
    {
        resultado.setMensaje(mensaje);
    }
    
    public void buildPublicacion(Publicacion publicacion)
    {
        resultado.setPublicacion(publicacion);
    }
    
    public void buildFechaHora(Calendar fechaHora)
    {
        resultado.setFechaHora(fechaHora);
    }
    
    
}
