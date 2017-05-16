/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import static m9uf1a6.M9UF1A6.ficheroOrigen;

/**
 *
 * @author ALUMNEDAM
 */
public class Desti {

    /*
    * Metodo para descifrar y comprovar el firmado.
    */
    public void descifrar() {
        try {
            //Instanciamos origen
            Origen o = new Origen();
            //Llamamos al metodo y asi generamos el keystore
            o.ametodo(ficheroOrigen, "123456");
            KeyStore ko = o.getKs();
            //Creamos una enumeracion con los datos del keystore
            Enumeration<String> aliases = ko.aliases();
            
            while (aliases.hasMoreElements()) { //Mientras tenga elementos imprime el siguiente
                System.out.println(aliases.nextElement());
            }
            //Instanciamos una privateKey
            PrivateKey pkey = (PrivateKey) ko.getKey("origen", "123456".toCharArray());
            //Instanciamos el objeto certificado para poder certificar la clave 
            X509Certificate c = (X509Certificate) ko.getCertificate("desticert");
            //Imprime la clave publica y verifica esta
            System.out.println(c.getPublicKey());
            c.verify(c.getPublicKey());

        } catch (NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException | InvalidKeyException | NoSuchProviderException | SignatureException ex) {
            Logger.getLogger(M9UF1A6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M9UF1A6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(M9UF1A6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(Desti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
