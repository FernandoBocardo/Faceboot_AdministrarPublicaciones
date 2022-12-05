/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.ComentariosDAO;
import Datos.IComentariosDAO;
import Dominio.Comentario;
import Dominio.Publicacion;
import Dominio.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class CtrlComentario{
    
    private static volatile CtrlComentario instance;
    private IComentariosDAO comentariosDAO;
    private ObjectMapper objectMapper;
    
    public CtrlComentario()
    {
        this.comentariosDAO = new ComentariosDAO();
        this.objectMapper = new ObjectMapper();
    }
    
    public static CtrlComentario getInstance() 
    {
        CtrlComentario result = instance;
        if (result != null) {
            return result;
        }
        synchronized(CtrlComentario.class) 
        {
            if(instance == null) 
            {
                instance = new CtrlComentario();
            }
        return instance;
        }
    }
    
    public Comentario mapper(String json)
    {
        Comentario comentario = null;
        try
        {
            comentario = objectMapper.readValue(json, Comentario.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return comentario;
    }
    
    public boolean registrarComentario(String comentarioJson, String usuarioJson)
    {
        Comentario comentario = mapper(comentarioJson);
        Usuario usuario = CtrlUsuario.getInstance().mapper(usuarioJson);
        comentario.setUsuario(usuario);
        if(comentariosDAO.registrarComentario(comentario))
        {
            return true;
        }
        return false;
    }
    
    public List<Comentario> consultarPorUsuario(String usuarioJson)
    {
        return comentariosDAO.consultarPorUsuario(CtrlUsuario.getInstance().mapper(usuarioJson));
    }
    
    public boolean eliminarComentario(String comentarioJson, String usuarioJson)
    {
        List<Comentario> comentariosDeUsuario = consultarPorUsuario(usuarioJson);
        if(comentariosDeUsuario.contains(mapper(comentarioJson)))
        {
            comentariosDAO.eliminarComentario(mapper(comentarioJson));
            return true;
        }
        return false;
    }
    
    public Comentario consultarComentario(String publicacionJson)
    {
        return comentariosDAO.consultarComentario(mapper(publicacionJson).getId());
    }
    
    public String consultarTodos()
    {
        List<Comentario> comentarios = comentariosDAO.consultarTodos();
        String comentariosJson = null;
        try 
        {
            comentariosJson = objectMapper.writeValueAsString(comentarios);
        } catch (JsonProcessingException ex) 
        {
            Logger.getLogger(CtrlComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentariosJson;
    }
    
    public String consultarPorPublicacion(String publicacionJson)
    {
        Publicacion publicacion = CtrlPublicacion.getInstance().mapper(publicacionJson);
        List<Comentario> comentarios = comentariosDAO.consultarPorPublicacion(publicacion);
        String comentariosJson = null;
        try 
        {
            comentariosJson = objectMapper.writeValueAsString(comentarios);
        } catch (JsonProcessingException ex) 
        {
            Logger.getLogger(CtrlComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentariosJson;
    }
    
}
