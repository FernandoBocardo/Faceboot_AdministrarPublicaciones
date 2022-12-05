/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.ComentariosDAO;
import Datos.IPublicacionesDAO;
import Datos.PublicacionesDAO;
import Dominio.Comentario;
import Dominio.Etiqueta;
import Dominio.Publicacion;
import Dominio.Usuario;
import Dominio.UsuarioEtiquetado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class CtrlPublicacion{
    
    private static volatile CtrlPublicacion instance;
    private IPublicacionesDAO publicacionesDAO;
    private ObjectMapper objectMapper;
    
    public CtrlPublicacion()
    {
        this.publicacionesDAO = new PublicacionesDAO();
        this.objectMapper = new ObjectMapper();
    }  
    
    public static CtrlPublicacion getInstance() 
    {
        CtrlPublicacion result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CtrlPublicacion.class) 
        {
            if(instance == null) 
            {
                instance = new CtrlPublicacion();
            }
        return instance;
        }
    }
    
    public Publicacion mapper(String json)
    {
        Publicacion publicacion = null;
        try
        {
            publicacion = objectMapper.readValue(json, Publicacion.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return publicacion;
    }
    
    public boolean registrarPublicacion(String publicacionJson, String usuarioJson)
    {
        Publicacion publicacion = mapper(publicacionJson);
        Usuario usuario = CtrlUsuario.getInstance().mapper(usuarioJson);
        publicacion.setUsuario(usuario);
        if(publicacionesDAO.registrarPublicacion(publicacion))
        {
            return true;
        }
        return false;
    }
    
    public boolean eliminarPublicacion(String publicacionJson, String usuarioJson)
    {
        if(publicacionesDAO.eliminarPublicacion(mapper(publicacionJson)))
        {
            return true;
        }
        return false;
    }
    
    public Publicacion consultarPublicacion(String publicacionJson)
    {
        return publicacionesDAO.consultarPublicacion(mapper(publicacionJson).getId());
    }
    
    public String listaPublicacionToJson(List<Publicacion> publicaciones)
    {
        String publicacionesJson = null;
        List<Publicacion> publicaciones2 = new ArrayList<>();
        for(Publicacion publicacion: publicaciones)
        {
            ComentariosDAO comentariosDAO = new ComentariosDAO();
            List<Comentario> comentarios = comentariosDAO.consultarPorPublicacion(publicacion);
            publicacion.setComentarios(comentarios);
            publicaciones2.add(publicacion);
        }
        try 
        {
            publicacionesJson = objectMapper.writeValueAsString(publicaciones2);
        } catch (JsonProcessingException ex) 
        {
            Logger.getLogger(CtrlPublicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publicacionesJson;
    }
    
    public String consultarTodas()
    {
        List<Publicacion> publicaciones = publicacionesDAO.consultarTodas();
        return listaPublicacionToJson(publicaciones);
    }
    
    public List<Publicacion> consultarPorUsuario(String usuarioJson)
    {
        return publicacionesDAO.consultarPorUsuario(CtrlUsuario.getInstance().mapper(usuarioJson));
    }
    
    public String consultarPorEtiqueta(String nombreEtiqueta)
    {
        Etiqueta etiqueta = new Etiqueta(nombreEtiqueta);
        List<Publicacion> publicaciones = publicacionesDAO.consultarPorEtiqueta(etiqueta);
        return listaPublicacionToJson(publicaciones);
    }
    
    public String consultarMencionPorUsusario(String nombreUsuario)
    {
        UsuarioEtiquetado usuarioEtiquetado = publicacionesDAO.consultarMencionPorUsusario(nombreUsuario);
        String usuarioEtiquetadoJson = null;
        try
        {
            usuarioEtiquetadoJson = objectMapper.writeValueAsString(usuarioEtiquetado);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return usuarioEtiquetadoJson;
    }
    
}
