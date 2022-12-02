/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.Publicacion;
import Dominio.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos
 */
public class PublicacionesDAO implements IPublicacionesDAO{
     private IConexionPublicacionesBD conexion;

        public PublicacionesDAO() {
        this.conexion = new ConexionPublicacionesBD();
    }
        
    @Override
    public boolean RegistrarPublicacion(Publicacion publicacion) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(publicacion);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo registrar la publicación");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean ConsultarUsuario(Publicacion publicacion,Usuario usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            publicacion.getUsuariosEtiquetados().contains(usuario);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar por usuario");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean EliminarPublicacion(Publicacion publicacion, Usuario usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            if(publicacion.getUsuario().getId()==usuario.getId()){
                em.remove(publicacion);
            }
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo eliminar la publicación");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean ConsultarEtiqueta(Publicacion etiqueta) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.contains(etiqueta.getEtiquetas());
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar por etiqueta");
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean EditarPublicacion(Publicacion publicacion, Usuario usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            if(publicacion.getUsuario().getId()==usuario.getId()){

            }
            else{
                System.err.print("No es su propia publicacion");
            }
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar por etiqueta");
            ex.printStackTrace();
            return false;
        }
    }
}
