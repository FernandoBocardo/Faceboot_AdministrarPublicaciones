/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.IPublicacionesDAO;
import Datos.PublicacionesDAO;
import Dominio.Etiqueta;
import Dominio.Publicacion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class CtrlPublicacion {
    
    private IPublicacionesDAO publicacionesDAO;
    
    public CtrlPublicacion()
    {
        this.publicacionesDAO = new PublicacionesDAO();
    }
    
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
    
    public boolean registrarPublicacion(String publicacionJson)
    {
        if(publicacionesDAO.registrarPublicacion(mapper(publicacionJson)))
        {
            return true;
        }
        return false;
    }
    
    public boolean eliminarPublicacion(String publicacionJson, String usuarioJson)
    {
        List<Publicacion> comentariosDeUsuario = consultarPorUsuario(usuarioJson);
        if(comentariosDeUsuario.contains(mapper(publicacionJson)))
        {
            publicacionesDAO.eliminarPublicacion(mapper(publicacionJson));
            return true;
        }
        return false;
    }
    
    public Publicacion consultarPublicacion(String publicacionJson)
    {
        return publicacionesDAO.consultarPublicacion(mapper(publicacionJson).getId());
    }
    
    public String consultarTodas()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Publicacion> publicaciones = publicacionesDAO.consultarTodas();
        String publicacionesJson = null;
        try 
        {
            publicacionesJson = objectMapper.writeValueAsString(publicaciones);
        } catch (JsonProcessingException ex) 
        {
            Logger.getLogger(CtrlPublicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publicacionesJson;
    }
    
    public List<Publicacion> consultarPorUsuario(String usuarioJson)
    {
        CtrlUsuario ctrlUsuario = new CtrlUsuario();
        return publicacionesDAO.consultarPorUsuario(ctrlUsuario.mapper(usuarioJson));
    }
    
    public List<Publicacion> consultarPorEtiqueta(String nombreEtiqueta)
    {
        Etiqueta etiqueta = new Etiqueta(nombreEtiqueta);
        return publicacionesDAO.consultarPorEtiqueta(etiqueta);
    }
    
}
