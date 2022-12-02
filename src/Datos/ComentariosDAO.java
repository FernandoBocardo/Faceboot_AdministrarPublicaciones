/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.Comentario;
import Dominio.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos
 */
public class ComentariosDAO implements IComentariosDAO{
    private IConexionUsuariosBD conexion;

        public ComentariosDAO() {
        this.conexion = new ConexionUsuariosBD();
    }
    
    @Override
    public boolean AgregarComentario(Comentario comentario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(comentario);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo agregar el comentario");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean EliminarComentario(Comentario comentario, Usuario usuario) {
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
    
}
