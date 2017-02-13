/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUMNEDAM
 */
public class M6UF1A1 {

    static String ruta = "archivo.txt";
    static File archivo = new File(ruta);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        crearArchivo();
        escribirArchivo();
        mostrarTamaño();
        busquedaDosValors(1, 2);

    }

    public static void mostrarTamaño() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        try {
            fis = new FileInputStream(archivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M6UF1A1.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fis = new FileInputStream(archivo);

            System.out.println("Tamaño total : "
                    + fis.available());

            int x;
            while ((x = fis.read()) != -1) {

                System.out.print((char) x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void crearArchivo() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        if (archivo.exists()) {
            System.out.println("El archivo ya existe");
            bw.write(2);
            bw.write(2);
        } else {
            System.out.println("Crear fichero: \n");

            System.out.println("Creado");

        }
        bw.close();
    }

    public static void escribirArchivo() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        try {
            if (raf.readUTF() == null) {
                raf.writeUTF(String.valueOf(2));
            } else {
                raf.seek(archivo.length() - 4);
                int ultimNum = raf.readInt();
                int numeroPrimSeguent = calculNumeroPrim(ultimNum);
                raf.seek(archivo.length());
                raf.writeInt(numeroPrimSeguent);
            }

            raf.close();
        } catch (Exception e) {
        }
    }

    /**
     * Metode que s'encarrega de realitzar el calcul de numeros prims.
     *
     * @param contador
     * @return
     */
    public static int calculNumeroPrim(int contador) {
        boolean seguir = true;
        int num = 0;
        do {
            if ((contador + 1) % 2 == 0) {
                num = contador + 1;
                seguir = false;
            }
            contador++;
        } while (seguir);
        return num;
    }

    public static ArrayList busquedaDosValors(int valor, int valor2) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        ArrayList ints = new ArrayList();
        raf.seek(0);
        boolean comprova = true;
        boolean comprovar2 = true;
        while (comprova) {
            int comparar = raf.read();

            if (valor >= comparar) {
                ints.add(comparar);
                while (comprovar2) {

                    int comparar2 = raf.readInt();

                    if (valor2 >= comparar2) {
                        comprovar2 = false;
                    } else {
                        ints.add(comparar);
                    }

                }
                comprova = false;
            }

        }
        raf.close();
        return ints;

    }

    public int nombrePosicio(int posicio) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        raf.seek(0);
        int numPrim = 0;

        int posicioNumero = (posicio * 4) - 4;
        raf.seek(posicioNumero);
        numPrim = raf.readInt();

        raf.close();
        return numPrim;
    }

    public int cantidadNumeros() throws FileNotFoundException, IOException {
        int num = 0;
        num = (int) (archivo.length() / 4);
        return num;

    }

    public int ultimNumero() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        String fitxer;
        int ultimPrim = 0;
        raf.seek(archivo.length() - 4);
        ultimPrim = raf.readInt();
        raf.close();
        return ultimPrim;
    }
}

//        LogManager.getLogManager().readConfiguration(new FileInputStream("./log.properties"));
//
////enregistrament dins d'una catch
//
//    Logger.getLogger(PersistenciaAdreca.class.getName()).log(Level.SEVERE, "prova", ex);

