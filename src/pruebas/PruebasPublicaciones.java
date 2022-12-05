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
import Dominio.Etiqueta;
import Dominio.Publicacion;
import Dominio.Usuario;
import Negocios.PublicacionBuilder;
import java.util.ArrayList;
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
        Usuario usuario = usuariosDAO.consultarUsuario(3L);
        Calendar fechaHora = new GregorianCalendar();
        PublicacionBuilder publicacionBuilder = new PublicacionBuilder();
        publicacionBuilder.buildMensaje("si");
        publicacionBuilder.buildUsuario(usuario);
        publicacionBuilder.buildFechaHora(fechaHora);
        publicacionesDAO.registrarPublicacion(publicacionBuilder.getResultado());
        //List<Publicacion> publicaciones = publicacionesDAO.consultarPorUsuario(usuario);
        //System.out.println(publicaciones);
        //Publicacion publicacionComentada = publicacionesDAO.consultarPublicacion(2L);
        //Comentario comentario = new Comentario("si, f", publicacionComentada);
        //comentariosDAO.registrarComentario(comentario);
        //Etiqueta etiqueta = new Etiqueta("twitter");
        //List<Etiqueta> etiquetas = new ArrayList<>();
        //etiquetas.add(etiqueta);
        //Publicacion publicacion = new Publicacion(usuario, "si", etiquetas, fechaHora, null);
        //publicacionesDAO.registrarPublicacion(publicacion);
        //List<Publicacion> publicacionesConEtiqueta = publicacionesDAO.consultarPorEtiqueta(etiqueta);
        System.out.println("a");
    }
    
}
