/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EztePaquetitoRico;

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

    public Ex2() throws FileNotFoundException  {
        this.p = new Producte();
    }
    
    public void escribir() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(file.length());
        raf.writeInt(5);
        raf.writeUTF("ProductoEjemplo");
        raf.writeDouble(1234);
        raf.writeInt(1);
        raf.close();
    }
    public int generarCodi() throws IOException {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(file.length()-16);
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

class Gestio {
    
}
class Producte {
    int codi,Unitats;
    String Nom;
    double preu;  
}
}
