/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E12;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ALUMNEDAM
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       Ex2 e = new Ex2();
       e.escribir();
       e.met();
       e.buscaPerNom("ProductoEjemplo");
       e.buscaPerCodi(1);
       e.modificarRegistre(1, 4, 100);
       e.mostrarRegistre();
       }
    
}
