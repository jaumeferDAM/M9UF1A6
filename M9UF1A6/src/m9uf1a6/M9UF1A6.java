/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a6;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUMNEDAM
 */
public class M9UF1A6 {
     static String ficheroOrigen = "C:\\Users\\ALUMNEDAM\\Documents\\NetBeansProjects\\M9UF1A6\\src\\SSL\\origen.jks";
    /**
     * @param args the command line arguments
     * @throws java.security.KeyStoreException
     */

     public static void main(String[] args) throws KeyStoreException {
       Origen o = new Origen("hola");
       Desti d = new Desti();
         try {
             o.ametodo(ficheroOrigen, "123456");
//             o.signData(ficheroOrigen, (PrivateKey) o.getKs().getKey(ficheroOrigen, password));
             d.descifrar();
         } catch (IOException | NoSuchAlgorithmException | CertificateException ex) {
             Logger.getLogger(M9UF1A6.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
}


