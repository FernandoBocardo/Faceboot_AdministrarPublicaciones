/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Dominio.Publicacion;
import Dominio.Usuario;

/**
 *
 * @author Carlos
 */
public interface IPublicacionesDAO {
    public boolean RegistrarPublicacion(Publicacion publicacion);
    public boolean ConsultarUsuario(Publicacion publicacion, Usuario usuario);
    public boolean ConsultarEtiqueta(Publicacion etiqueta);
    public boolean EliminarPublicacion(Publicacion publicacion, Usuario usuario);
    public boolean EditarPublicacion(Publicacion publicacion, Usuario usuario);
}
