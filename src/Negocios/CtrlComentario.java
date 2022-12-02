/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.ComentariosDAO;
import Dominio.Comentario;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Carlos
 */
public class CtrlComentario {
    private ComentariosDAO comentariosDAO = new ComentariosDAO();
    
    public Comentario mapper(String json)
    {
        Comentario publicacion = null;
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            publicacion = objectMapper.readValue(json, Comentario.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return publicacion;
    }
    
    public boolean AgregarComentario(String usuarioJson)
    {
        if(comentariosDAO.AgregarComentario(mapper(usuarioJson)))
        {
            return true;
        }
        return false;
    }
    
    public boolean EliminarComentario(String usuarioJson)
    {
        if(comentariosDAO.EliminarComentario(mapper(usuarioJson),null))
        {
            return true;
        }
        return false;
    }
}
