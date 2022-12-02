/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Dominio.Publicacion;
import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface IPublicacionesDAO {
    public boolean RegistrarPublicacion(Publicacion publicacion);
    public Publicacion consultarPublicacion(Long id);
    public List<Publicacion> consultarTodas();
    public List<Publicacion> consultarPorUsuario(Usuario usuario);
}
