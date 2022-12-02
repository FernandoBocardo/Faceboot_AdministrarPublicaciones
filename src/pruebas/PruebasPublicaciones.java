/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Datos.ComentariosDAO;
import Datos.IComentariosDAO;
import Datos.IPublicacionesDAO;
import Datos.IUsuariosDAO;
import Datos.PublicacionesDAO;
import Datos.UsuariosDAO;
import Dominio.Comentario;
import Dominio.Publicacion;
import Dominio.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class PruebasPublicaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IPublicacionesDAO publicacionesDAO = new PublicacionesDAO();
        IComentariosDAO comentariosDAO = new ComentariosDAO();
        IUsuariosDAO usuariosDAO = new UsuariosDAO();
        Usuario usuario = usuariosDAO.consultar(1L);
        Calendar fechaHora = new GregorianCalendar();
        //Publicacion publicacion = new Publicacion(usuario, "si", null, fechaHora, null);
        //publicacionesDAO.RegistrarPublicacion(publicacion);
        //List<Publicacion> publicaciones = publicacionesDAO.consultarPorUsuario(usuario);
        //System.out.println(publicaciones);
        Publicacion publicacionComentada = publicacionesDAO.consultarPublicacion(1L);
        //Comentario comentario = new Comentario("si, f", publicacionComentada);
        //comentariosDAO.AgregarComentario(comentario);
        System.out.println("a");
    }
    
}
