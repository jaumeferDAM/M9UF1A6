/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a1;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author ALUMNEDAM
 */
public class SeguretatAES {
    
    void crearContrasenya() {
        int keySize = 0;
        String key;
        KeyPairGenerator generator = null;
        while (keySize != 128 && keySize != 192 && keySize != 256) {
            System.out.println("Introdueix el tamany de la clau (128, 192 o 256): ");
            Scanner sc = new Scanner(System.in);
            keySize = sc.nextInt();
            KeyPair claveGenerada = generator.genKeyPair();
            
        }
    }
    
   void xifrarFitxer(String fitxer, SecretKey clau) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
       //push
        Cipher cipher = Cipher.getInstance(fitxer);
        cipher.init(Cipher.ENCRYPT_MODE, clau);
        
    }
}
