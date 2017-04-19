/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a1;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ALUMNEDAM
 */
public class SeguretatAES {

    private String contrasenya = "Contrasenya";

    SecretKey crearContrasenya() {
        int keySize = 0;
        String key = null;
        KeyPair claveGenerada;
         SecretKey skey = null;

         while (keySize != 128 && keySize != 192 && keySize != 256) {
            System.out.println("Introdueix el tamany de la clau (128, 192 o 256): ");
            Scanner sc = new Scanner(System.in);
            keySize = sc.nextInt();
//            claveGenerada = generator.genKeyPair();
            try {
                byte[] data = contrasenya.getBytes();
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key1 = Arrays.copyOf(hash, keySize / 8);
                skey = new SecretKeySpec(key1, "AES");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(SeguretatAES.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return skey;
    }

    void xifrarFitxer(String fitxer, SecretKey clau) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, FileNotFoundException, IOException {
        //push
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, clau);
        FileInputStream fis = null;
        byte b[] = new byte[1000];
        
            fis = new FileInputStream(fitxer);
        
        
            FileOutputStream fos = new FileOutputStream("fitxerEncriptado.txt");
            while (fis.read(b, 0, b.length) != -1) {
                fos.write(b, 0, b.length);
                cipher.update(b, 0, b.length);
            }
        try {
            byte[] arrayCifrado = cipher.doFinal();
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(SeguretatAES.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
