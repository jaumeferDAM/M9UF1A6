package E13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.zip.GZIPOutputStream;


/**
 *
 * @author ALUMNEDAM
 */
public class E1_3 {
    String ruta1 = "fichero1";
    String ruta2 = "fichero2";
    File fitxerLlegir = new File(ruta1);
    File fitxerEscriure = new File(ruta2);
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    /**
     * @param fitxerLlegir
     * @param fitxerEscriure
     */
    public void copiarFitxersBuffers(File fitxerLlegir, File fitxerEscriure) {
        try {
            try {

                bufferedReader = new BufferedReader(new FileReader(fitxerLlegir));
                bufferedWriter = new BufferedWriter(new FileWriter(fitxerEscriure));
                String linea;

                while ((linea = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(linea + "\n");
                    System.out.println(linea);
                }
                bufferedReader.close();
                bufferedWriter.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param fitxerLlegir
     * @param fitxerEscriure
     */
    public void copiarFitxersBuffersComprimit(File fitxerLlegir, File fitxerEscriure) throws FileNotFoundException, IOException {
        BufferedReader lector = new BufferedReader(new FileReader(fitxerLlegir));
        GZIPOutputStream gzip = new GZIPOutputStream(new FileOutputStream(fitxerEscriure));
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(gzip));

        String linea;

        while ((linea = lector.readLine()) != null) {
            escritor.write(linea);
            escritor.flush();
        }
    }

    /**
     * @param cadena
     * @param fitxer
     * @return 
     * @throws java.io.IOException
     */
    public boolean CercarCadenaText(String cadena, File fitxer) throws IOException {

        BufferedReader lector = new BufferedReader(new FileReader(fitxerLlegir));
        boolean valor = false;
        String linea;

        while ((linea = lector.readLine()) != null) {

            if (linea.equals(cadena)) {
                valor = true;
            }
        }
        
        return valor;
    }

    /**
     * Metode que rep una URL i un File i escriu en el File el contingut de la
     * URL.
     *
     * @param url
     * @param fitxer
     * @throws Exception
     */
    public void descarregarURL(String url, File fitxer) throws Exception {

        URL direccio = new URL(url);
        OutputStream outputStream;
        try (InputStream inputStream = direccio.openStream()) {
            outputStream = new FileOutputStream(fitxer);
            byte[] dades = new byte[2048];
            int longitud;
            while ((longitud = inputStream.read(dades)) != -1) {
                outputStream.write(dades, 0, longitud);
            }
        }
        outputStream.close();

    }

}