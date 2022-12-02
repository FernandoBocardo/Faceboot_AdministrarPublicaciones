/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Dominio.Comentario;
import Dominio.Usuario;

/**
 *
 * @author Carlos
 */
public interface IComentariosDAO {
    public boolean AgregarComentario(Comentario comentario);
    public boolean EliminarComentario(Comentario comentario, Usuario usuario);
}
