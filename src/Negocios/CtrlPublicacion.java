/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.PublicacionesDAO;
import Dominio.Publicacion;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Carlos
 */
public class CtrlPublicacion {
    private PublicacionesDAO publicacionesDAO = new PublicacionesDAO();
    
    public Publicacion mapper(String json)
    {
        Publicacion publicacion = null;
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            publicacion = objectMapper.readValue(json, Publicacion.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return publicacion;
    }
    
    public boolean RegistrarPublicacion(String usuarioJson)
    {
        if(publicacionesDAO.RegistrarPublicacion(mapper(usuarioJson)))
        {
            return true;
        }
        return false;
    }
    
    public boolean EditarPublicacion(String publicacionJson)
    {
        if(publicacionesDAO.EditarPublicacion(mapper(publicacionJson),null))
        {
            return true;
        }
        return false;
    }
    
    public boolean ConsultarEtiqueta(String publicacionJson)
    {
        if(publicacionesDAO.ConsultarEtiqueta(mapper(publicacionJson)))
        {
            return true;
        }
        return false;
    }
    
    public boolean EliminarPublicacion(String publicacionJson)
    {
        if(publicacionesDAO.EliminarPublicacion(mapper(publicacionJson),null))
        {
            return true;
        }
        return false;
    }
    
    public boolean ConsultarUsuario(String publicacionJson)
    {
        if(publicacionesDAO.ConsultarUsuario(mapper(publicacionJson),null))
        {
            return true;
        }
        return false;
    }
}
