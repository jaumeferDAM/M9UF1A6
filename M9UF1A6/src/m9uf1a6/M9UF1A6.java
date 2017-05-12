/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
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
     */
    public static void main(String[] args) throws KeyStoreException {
        try {
            Origen o = new Origen();
            o.ametodo(ficheroOrigen,"123456");
            KeyStore ko = o.getKs();
            Enumeration<String> aliases = ko.aliases();
            while (aliases.hasMoreElements()) {
                System.out.println(aliases.nextElement());
            }
            
            PrivateKey pkey = (PrivateKey) ko.getKey("origen", "123456".toCharArray());
       
            X509Certificate c = (X509Certificate) ko.getCertificate("desticert");
            System.out.println(c.getPublicKey());

            
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException ex) {
            Logger.getLogger(M9UF1A6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
             Logger.getLogger(M9UF1A6.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(M9UF1A6.class.getName()).log(Level.SEVERE, null, ex);
         }
        } 

    }


