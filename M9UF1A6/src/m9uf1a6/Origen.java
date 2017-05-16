/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a6;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static m9uf1a6.M9UF1A6.ficheroOrigen;

/**
 *
 * @author ALUMNEDAM
 */
public class Origen {

    //Guardamos en una variable Keystore el almacen que pasaremos al destino.
    KeyStore ks;
    String texto;

    //Construtor
    public Origen(String texto) {
        this.texto = texto;
    }

    public Origen() {
    }

    /*
    * Metodo que cifra un fichero con la contraseña pasada por parametro.
     */
    public void ametodo(String ksfile, String passwd) throws IOException, NoSuchAlgorithmException, CertificateException {

        try {
            //Instanciamos el keystore en JCEKS.
            ks = KeyStore.getInstance("JCEKS");
            //Creamos un inputStream para escribir en el fichero
            FileInputStream fis1 = new FileInputStream(ficheroOrigen);
            //Instanciamos un file
            File f = new File(ksfile);
            if (f.isFile()) {   //Si es de tipo file
                //Carga el keyStore desde el inputStream
                ks.load(fis1, "123456".toCharArray());
            }
        } catch (KeyStoreException | FileNotFoundException ex) {
            Logger.getLogger(Origen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    * Metodo que firma un fichero.
     */
    public byte[] signData(String fitxer, PrivateKey priv) {
        //Variables a instanciar
        byte[] signature = null;
        FileInputStream fis;
        BufferedInputStream bis;
        byte[] buffer = new byte[1024];
        int mida;

        try {
            //Instanciamos el bufferedInput i el fileInput para leer el fichero.
            fis = new FileInputStream(fitxer);
            bis = new BufferedInputStream(fis);

            //Inicializamos el signer para la firma.
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(priv); //Inicialitzem la firma digital a partir de l ’algorisme utilitzat

            //Recorremos el archivo.
            while (bis.available() != 0) {
                mida = bis.read(buffer);
                signer.update(buffer, 0, mida); //Le asignamos la firma al objeto signer.
            }

            //Se cierra el recurso.
            bis.close();
            signature = signer.sign(); //Se firma.
        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException | SignatureException ex) {
            System.err.println("Error signant les dades: " + ex);
        }
        return signature;
    }

    public KeyStore getKs() {
        return ks;
    }

    public void setKs(KeyStore ks) {
        this.ks = ks;
    }

}
