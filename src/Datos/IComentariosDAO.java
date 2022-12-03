/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Dominio.Comentario;
import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface IComentariosDAO {
    public boolean registrarComentario(Comentario comentario);
    public boolean eliminarComentario(Comentario comentario);
    public Comentario consultarComentario(Long id_comentario);
    public List<Comentario> consultarTodos();
    public List<Comentario> consultarPorUsuario(Usuario usuario);
}
