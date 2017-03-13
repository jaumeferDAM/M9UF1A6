/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6uf2a1;

import Controlador.Asseguradora_controller;
import Controlador.Cliente_controller;
import Controlador.Polissa_Controller;
import Controlador.Usuari_controller;
import Controlador.Vehicle_controller;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import modelo.Adreca;
import modelo.Asseguradora;
import modelo.Cliente;
import modelo.Polissa;
import modelo.TIPODESEGURO;
import modelo.Usuari;
import modelo.Vehicles;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionFactoryImpl;

/**
 *
 * @author ALUMNEDAM
 */
public class M6UF2A1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inicialitzem tots els controladors
        Cliente_controller controller_cliente = new Cliente_controller();
        Asseguradora_controller asseguradora_controller = new Asseguradora_controller();
        Usuari_controller usuari_Controller = new Usuari_controller();
        Vehicle_controller vehicle_controller = new Vehicle_controller();
        Polissa_Controller polissa_Controller = new Polissa_Controller();

        //Crear una adreca per afegir al client
        Adreca adreca = new Adreca("una", 42, "Barbera");
  
  //USUARI
   
        //Crear un usuari
        Usuari u1 = new Usuari("admin", "1234");
        //insertar l'usuari
        usuari_Controller.Insertar(u1);
        //Crear un altre ¡usuari per modificar l'anterior
        Usuari u2 = usuari_Controller.Buscar("admin");
        u2.setPassword("aaaa");
        //Realitzem la modificacio
        usuari_Controller.Modificar(u2);
        System.out.println("Cerca de usuari per id: " + usuari_Controller.Buscar("admin"));
        //Creem un altre usuari per eliminar
        Usuari u3 = usuari_Controller.Buscar("admin");
        //Eliminem l'usuari
        usuari_Controller.Eliminar(u3);
        
   //CLIENTE

        
        //Crear un client
        Cliente C1 = new Cliente(0, "Matias", 98975445L, adreca);
        //insertar l'client
        controller_cliente.Insertar(C1);
//        //Crear un altre ¡client per modificar l'anterior
        Cliente c2 = controller_cliente.buscar(1421);
        c2.setNombre("Abel");
//        //Realitzem la modificacio
        controller_cliente.Modificar(c2);
        System.out.println("Cerca de client per id: " + controller_cliente.buscar(1241));
//        //Creem un altre client per eliminar
        Cliente c3 = controller_cliente.buscar(1421);

        
        /* Hay que eliminar todas las relaciones
        Guardar las polizas del cliente */
        List<Polissa> polissas1 = (List<Polissa>) polissa_Controller.BuscarPolissaClient(c3.getIdCliente());
        for (Polissa polissa : polissas1) {
            //Obtenemos el vehiculo y su poliza
            Vehicles vehi3 = polissa.getVehicle();
            vehi3.setPropietari(null);
            //Realitzem la modificacio
            vehicle_controller.Modificar(vehi3);
        }
        //Eliminar las polizas de el cliente que queremos eliminar
        polissa_Controller.EliminarPolissaClient(polissa_Controller.BUSCALLISTA(c3.getIdCliente()));
        //Busqueda por nombre
        controller_cliente.imprimirCliente(controller_cliente.buscarPorNombre("Matias"));
        //Busqueda polizas de un cliente
        polissa_Controller.BuscarPolissaClient(controller_cliente.buscarPorNombre("Matias").getIdCliente());
        //Muestra polizas vigentees
        polissa_Controller.BuscarPolissaVigents();
        //Eliminem el client
        controller_cliente.Eliminar(c3);

    //VEHICLE
        Cliente clientev = controller_cliente.buscar(1461);
        //Crear un vehiculo
        Vehicles v = new Vehicles(0, "Seat", "ffffff", 2005, clientev, "Cordoba");
        //Insertar el vehiculo
        vehicle_controller.Insertar(v);
        System.out.println(v);
         Vehicles vehiModificar = vehicle_controller.Buscar(1821); 
            vehiModificar.setMarca("Opel");
            vehicle_controller.Modificar(vehiModificar);
            Vehicles vehiPerEliminar = vehicle_controller.Buscar(2141);
            //Eliminar la polissa 
            Polissa poliEliminar = polissa_Controller.BuscarPolissaVehicle(vehiPerEliminar.getId());
            polissa_Controller.Eliminar(poliEliminar);
            vehicle_controller.Eliminar(vehiPerEliminar);
            
            
    //Asseguradora
    
    
        //Crear una asseguradora
        Asseguradora asseguradora = new Asseguradora(0, "Ocaso", "NIF");
        //Cojer la poliza que tendra asseguradora
        List<Polissa> polizas = new ArrayList<>();
        polizas.add((Polissa) polissas1);
        asseguradora.setPolissa(polizas);
        //Insertamos la asseguradora
        asseguradora_controller.Insertar(asseguradora);
        //Creamos otra con el id anterior para modificarla
        Asseguradora asseguradoraMod = asseguradora_controller.Buscar(1301);
        asseguradoraMod.setNif("NIF1");
        asseguradora_controller.Modificar(asseguradoraMod);
        
        asseguradoraMod.setPolissa(null);
        Asseguradora elimAsseguradora = asseguradora_controller.Buscar(1301);
        asseguradora_controller.Eliminar(elimAsseguradora);
        
        

        
        
        
    }

}
