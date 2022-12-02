/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.Publicacion;
import Dominio.Usuario;
import java.util.List;
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
    public Publicacion consultarPublicacion(Long id_publicacion) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Publicacion.class, id_publicacion);
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo encontrar la publicación con el ID: " + id_publicacion);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Publicacion> consultarTodas() {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.createQuery(
                "SELECT p FROM Publicacion p")
                .getResultList();
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar las publicaciones");
            ex.printStackTrace();
            return null;
        }
    }
    
     @Override
    public List<Publicacion> consultarPorUsuario(Usuario usuario)
    {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.createQuery(
                "SELECT p FROM Publicacion p WHERE p.usuario = ?1")
                .setParameter(1, usuario)
                .getResultList();
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar las publicaciones");
            ex.printStackTrace();
            return null;
        }
    }

}
