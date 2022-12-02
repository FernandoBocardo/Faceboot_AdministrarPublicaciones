/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando
 */
public class ConexionPublicacionesBD implements IConexionPublicacionesBD{
    @Override
    public EntityManager crearConexion() throws IllegalStateException {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Faceboot_AdministrarPublicacionesPU");
        EntityManager em = emFactory.createEntityManager();
        return em;
    }
}
