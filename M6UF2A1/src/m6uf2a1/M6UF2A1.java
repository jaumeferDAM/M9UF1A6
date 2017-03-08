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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import modelo.Adreca;
import modelo.Asseguradora;
import modelo.Cliente;
import modelo.Polissa;
import modelo.Usuari;
import modelo.Vehicles;

/**
 *
 * @author ALUMNEDAM
 */
public class M6UF2A1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente_controller controller_cliente = new Cliente_controller();
        Asseguradora_controller asseguradora_controller = new Asseguradora_controller();
        Usuari_controller usuari_Controller = new Usuari_controller();
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Jaume");
        cliente2.setIdCliente(0);
        cliente2.setTelefono((long)938473893);
       
        
        Adreca adreca1 = new Adreca();
        adreca1.setCarrer("MONTURIOL");
        adreca1.setNumero(123);
        adreca1.setPoblacio("MONTCADA");
        
        cliente2.setAdreca(adreca1);
        
        
//        
//       
//        
        Vehicles vehicle1 = new Vehicles();
        vehicle1.setId(0);
        vehicle1.setAnyfabricacio(2004);
        vehicle1.setMarca("SEAT");
        vehicle1.setMatricula("93843-N");
        vehicle1.setModel("IBIZA");
        vehicle1.setPropietari(cliente2);
//        
         Polissa polissa1 = new Polissa();
        Date fechaCaducidad = new Date(2018, 4, 21);
        Date fechaInicio = new Date(2017, 3, 3);
        polissa1.setDataFi(fechaCaducidad);
        polissa1.setDataInici(fechaInicio);
        polissa1.setNumero("0");
        polissa1.setPrenedor(cliente2);
        polissa1.setPrima((float)3454);
        
        List<Polissa> polisses = new ArrayList<>();
           
        polisses.add(polissa1);
        
        Asseguradora asseguradora1 = new Asseguradora();
        asseguradora1.setId(0);
        asseguradora1.setNif("4543889");
        asseguradora1.setNom("OCCIDENTE SEGUROS");
        asseguradora1.setPolissa(polisses);
        
        
        cliente2.setPolissa(polissa1);
//        
//        TIPODESEGURO TOT_RISC = TIPODESEGURO.TOT_RISC;
//        polissa1.setTipus(TOT_RISC);
//        polissa1.setVehicle(vehicle1);

//        
        Usuari usuari1 = new Usuari();
        usuari1.setNom("Moreno");
        usuari1.setPassword("1234");
//        controller_cliente.Insertar(cliente1);
        Vehicle_controller v = new Vehicle_controller();
        Polissa_Controller controller = new Polissa_Controller();
//        controller.Insertar(polissa1);
//        v.Insertar(vehicle1);
//           asseguradora_controller.Insertar(asseguradora1);
//            usuari_Controller.Insertar(usuari1);
            Vehicles vehicle2 = new Vehicles(0, "IMPREZA", "343434-BC", 2001, cliente2, "SUBARU", polissa1);
            v.Insertar(vehicle2);
//        controller_cliente.Insertar(cliente2);
//        controller.Buscar((short)1);

    }
    
}
