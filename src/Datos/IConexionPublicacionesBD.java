/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import javax.persistence.EntityManager;

/**
 *
 * @author Fernando
 */
public interface IConexionPublicacionesBD {
    public EntityManager crearConexion() throws IllegalStateException;
}
