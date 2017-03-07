/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6uf2a1;

import Controlador.Cliente_controller;
import Controlador.Polissa_Controller;
import Controlador.Vehicle_controller;
import java.util.Date;
import modelo.Adreca;
import modelo.Cliente;
import modelo.Polissa;
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
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Eric");
//        cliente1.setIdCliente(0);
        cliente1.setTelefono((long)938473893);
        
        
        Adreca adreca1 = new Adreca();
        adreca1.setCarrer("MONTURIOL");
        adreca1.setNumero(123);
        adreca1.setPoblacio("MONTCADA");
        
        cliente1.setAdreca(adreca1);
        
//        Asseguradora asseguradora1 = new Asseguradora();
//        asseguradora1.setNif("454388987-G");
//        asseguradora1.setNom("OCCIDENTE SEGUROS");
//        
//       
//        
        Vehicles vehicle1 = new Vehicles();
        vehicle1.setId(0);
        vehicle1.setAnyfabricacio(2004);
        vehicle1.setMarca("SEAT");
        vehicle1.setMatricula("93843-N");
        vehicle1.setModel("IBIZA");
        vehicle1.setPropietari(cliente1);
//        
         Polissa polissa1 = new Polissa();
        Date fechaCaducidad = new Date(2018, 4, 21);
        Date fechaInicio = new Date(2017, 3, 3);
        polissa1.setDataFi(fechaCaducidad);
        polissa1.setDataInici(fechaInicio);
        polissa1.setNumero("0");
        polissa1.setPrenedor(cliente1);
        polissa1.setPrima((float)3454);
//        
//        TIPODESEGURO TOT_RISC = TIPODESEGURO.TOT_RISC;
//        polissa1.setTipus(TOT_RISC);
//        polissa1.setVehicle(vehicle1);
//        
//        cliente1.setVehicles(vehicle1);
//        /*cliente1.setAdreca(null);
//        Vehicles vehicles;
//        cliente1.setVehicles(vehicles);*/
//        
//        Usuari usuari1 = new Usuari();
//        usuari1.setNom("Moreno");
//        usuari1.setPassword("1234");
//        
//        controller_cliente.Insertar(cliente1);
        Vehicle_controller v = new Vehicle_controller();
        Polissa_Controller controller = new Polissa_Controller();
        controller.Insertar(polissa1);
//        v.Insertar(vehicle1);
        
//        controller_cliente.Buscar(1);
//        controller.Buscar((short)1);

    }
    
}
