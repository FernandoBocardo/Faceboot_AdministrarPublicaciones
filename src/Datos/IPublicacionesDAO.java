/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Dominio.Etiqueta;
import Dominio.Publicacion;
import Dominio.Usuario;
import Dominio.UsuarioEtiquetado;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface IPublicacionesDAO {
    public boolean registrarPublicacion(Publicacion publicacion);
    public boolean eliminarPublicacion(Publicacion publicacion);
    public Publicacion consultarPublicacion(Long id_publicacion);
    public List<Publicacion> consultarTodas();
    public List<Publicacion> consultarPorUsuario(Usuario usuario);
    public List<Publicacion> consultarPorEtiqueta(Etiqueta etiqueta);
    public UsuarioEtiquetado consultarMencionPorUsusario(String nombreUsuario);
}
