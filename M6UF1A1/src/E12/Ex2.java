/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author ALUMNEDAM
 */
public class Ex2 {

    private static final String ruta = "fichero.txt";
    File file = new File(ruta);

    Producte p;

    public Ex2() throws FileNotFoundException {
        this.p = new Producte();
    }

    public void escribir() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(file.length());
        raf.writeInt(5);
        raf.writeUTF("ProductoEjemplo69");
        raf.writeDouble(1234);
        raf.writeInt(1);
        raf.close();
    }

    public int generarCodi() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(file.length() - 16);
        raf.readUTF();
        return 3;
    }

    public void met() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(0);
        System.out.println("Codigo del producto: " + raf.readInt());
        System.out.println("Producto nombre: " + raf.readUTF());
        System.out.println("Precio: " + raf.readDouble());
        System.out.println("Cantidad: " + raf.readInt());
        raf.close();
    }

    public void buscaPerNom(String nom) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int codi, cantidad;
        String s;
        double precio;
                raf.seek(0);

        while (raf.getFilePointer() < file.length()) {
            codi = raf.readInt();
            s = raf.readUTF();
            precio = raf.readDouble();
            cantidad = raf.readInt();
            if (s.equals(nom)) {
                System.out.println("Codigo del producto: " + codi);
                System.out.println("Nom producte: " + nom);
                System.out.println("Precio: " + precio);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("------------------------------");
                break;
            }
        }
        raf.close();

    }

    public void buscaPerCodi(int codi) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int numero, cantidad;
        String s;
        double precio;
             raf.seek(0);

        while (raf.getFilePointer() < file.length()) {
            numero = raf.readInt();
            s = raf.readUTF();
            precio = raf.readDouble();
            cantidad = raf.readInt();
            if (numero == codi) {
                System.out.println("Codigo del producto: " + codi);
                System.out.println("Nom producte: " + s);
                System.out.println("Precio: " + precio);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("------------------------------");
                break;
            }
        }
        raf.close();
    }

    public void modificarRegistre(int codi, int unitats, double preu) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int numero, cantidad;
        String s;
        double precio;
                raf.seek(0);

        while (raf.getFilePointer() < file.length()) {
            numero = raf.readInt();
            s = raf.readUTF();
            precio = raf.readDouble();
            cantidad = raf.readInt();
            if (numero == codi) {
                System.out.println("Codigo del producto: " + codi);
                System.out.println("Nom producte: " + s);
                System.out.println("Precio Actulizado: " + preu);
                System.out.println("Cantidad Actualizada: " + unitats);
                System.out.println("------------------------------");
                break;
            }
        }
        raf.close();
    }

    public void mostrarRegistre() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        int numero, cantidad;
        String s;
        double precio;
        raf.seek(0);

        do {
           

            System.out.println("Codigo del producto: " + raf.readInt());
            System.out.println("Nom producte : " + raf.readUTF());
            System.out.println("Precio: " + raf.readDouble());
            System.out.println("Cantidad: " + raf.readInt());
            System.out.println("------------------------------");
        } while (raf.getFilePointer() < file.length());
        raf.close();
    }

    class Gestio {

    }

    class Producte {

        int codi, Unitats;
        String Nom;
        double preu;
    }
}
