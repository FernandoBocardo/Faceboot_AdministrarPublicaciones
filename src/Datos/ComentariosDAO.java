/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.Comentario;
import Dominio.Publicacion;
import Dominio.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos
 */
public class ComentariosDAO implements IComentariosDAO{
    
    private IConexionPublicacionesBD conexion;

    public ComentariosDAO() 
    {
        this.conexion = ConexionPublicacionesBD.getInstance();
    }
    
    @Override
    public boolean registrarComentario(Comentario comentario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(comentario);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo registrar el comentario");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarComentario(Comentario comentario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.remove(comentario);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo eliminar el comentario");
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Comentario> consultarPorUsuario(Usuario usuario)
    {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.createQuery(
                "SELECT c FROM Comentario c WHERE c.usuario = ?1")
                .setParameter(1, usuario)
                .getResultList();
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar los comentarios");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Comentario consultarComentario(Long id_comentario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Comentario.class, id_comentario);
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo encontrar el comentario con el ID: " + id_comentario);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comentario> consultarTodos() {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.createQuery(
                "SELECT c FROM Comentario c")
                .getResultList();
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar los comentarios");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comentario> consultarPorPublicacion(Publicacion publicacion) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.createQuery(
                "SELECT c FROM Comentario c WHERE c.publicacion = ?1")
                .setParameter(1, publicacion)
                .getResultList();
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar los comentarios");
            ex.printStackTrace();
            return null;
        }
    }
    
}
