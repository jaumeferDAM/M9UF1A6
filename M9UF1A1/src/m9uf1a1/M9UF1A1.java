/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a1;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author ALUMNEDAM
 */
public class M9UF1A1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SeguretatAES sea = new SeguretatAES();
        SecretKey clau = sea.crearContrasenya();
        try {
            sea.xifrarFitxer("fichero.txt", clau);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
            Logger.getLogger(M9UF1A1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
