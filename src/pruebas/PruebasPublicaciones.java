/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Datos.IPublicacionesDAO;
import Datos.IUsuariosDAO;
import Datos.PublicacionesDAO;
import Datos.UsuariosDAO;
import Dominio.Publicacion;
import Dominio.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        IUsuariosDAO usuariosDAO = new UsuariosDAO();
        Usuario usuario = usuariosDAO.consultar(1L);
        Calendar fechaHora = new GregorianCalendar();
        Publicacion publicacion = new Publicacion(usuario, "perdio mexico nms", null, fechaHora, null);
        publicacionesDAO.RegistrarPublicacion(publicacion);
        
    }
    
}
