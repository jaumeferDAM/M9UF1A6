/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6uf2a1;

import Controlador.Controller;
import modelo.Cliente;

/**
 *
 * @author ALUMNEDAM
 */
public class M6UF2A1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controller controller = new Controller();
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Jaume");
        cliente1.setIdCliente((short)1);
        cliente1.setTelefono((long)938473893);
        
                    controller.Insertar(cliente1);

    }
    
}
