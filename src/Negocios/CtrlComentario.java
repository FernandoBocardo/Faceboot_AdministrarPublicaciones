/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.ComentariosDAO;
import Datos.IComentariosDAO;
import Dominio.Comentario;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    
    public boolean AgregarComentario(String comentarioJson)
    {
        if(comentariosDAO.AgregarComentario(mapper(comentarioJson)))
        {
            return true;
        }
        return false;
    }
    
    public boolean EliminarComentario(String comentarioJson)
    {
        if(comentariosDAO.EliminarComentario(mapper(comentarioJson)))
        {
            return true;
        }
        return false;
    }
}
