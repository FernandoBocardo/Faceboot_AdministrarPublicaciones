/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.ComentariosDAO;
import Datos.IComentariosDAO;
import Dominio.Comentario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class CtrlComentario {
    
    private IComentariosDAO comentariosDAO;
    
    public CtrlComentario()
    {
        this.comentariosDAO = new ComentariosDAO();
    }
    
    public Comentario mapper(String json)
    {
        Comentario comentario = null;
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            comentario = objectMapper.readValue(json, Comentario.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return comentario;
    }
    
    public boolean registrarComentario(String comentarioJson)
    {
        if(comentariosDAO.registrarComentario(mapper(comentarioJson)))
        {
            return true;
        }
        return false;
    }
    
    public List<Comentario> consultarPorUsuario(String usuarioJson)
    {
        CtrlUsuario ctrlUsuario = new CtrlUsuario();
        return comentariosDAO.consultarPorUsuario(ctrlUsuario.mapper(usuarioJson));
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
    
    public List<Comentario> consultarTodos()
    {
        return comentariosDAO.consultarTodos();
    }
    
}
