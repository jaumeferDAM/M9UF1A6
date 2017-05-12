/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static m9uf1a6.M9UF1A6.ficheroOrigen;

/**
 *
 * @author ALUMNEDAM
 */
public class Origen {

    KeyStore ks;
    String texto;

    public Origen(String texto) {
        this.texto = texto;
    }

    Origen() {
    }

    public void ametodo(String ksfile, String passwd) throws IOException, NoSuchAlgorithmException, CertificateException {

        try {
            ks = KeyStore.getInstance("JCEKS");
            FileInputStream fis1 = new FileInputStream(ficheroOrigen);
            ks.load(fis1, "123456".toCharArray());
            File f = new File(ksfile);
            if (f.isFile()) {
                FileInputStream fis2 = new FileInputStream(f);
            }
        } catch (KeyStoreException | FileNotFoundException ex) {
            Logger.getLogger(Origen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public KeyStore getKs() {
        return ks;
    }

    public void setKs(KeyStore ks) {
        this.ks = ks;
    }

}
