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
    
    private static volatile ConexionPublicacionesBD instance;
    private EntityManager em;
    
    public static ConexionPublicacionesBD getInstance() 
    {
        ConexionPublicacionesBD result = instance;
        if (result != null) {
            return result;
        }
        synchronized(ConexionPublicacionesBD.class) 
        {
            if(instance == null) 
            {
                instance = new ConexionPublicacionesBD();
            }
        return instance;
        }
    }
    
    @Override
    public EntityManager crearConexion() throws IllegalStateException {
        if(this.em == null)
        {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Faceboot_AdministrarPublicacionesPU");
            this.em = emFactory.createEntityManager();
        }
        return em;
    }
}
