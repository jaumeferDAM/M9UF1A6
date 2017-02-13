/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoraque;

import java.util.Arrays;
import yahoraque.IPila.Node;

/**
 *
 * @author ALUMNEDAM
 */
public class ManipularFigures {

    /**
     *
     * @param figures
     * @return
     */
    public double mitjanaPerimetre(IPilaImpl<Figura> figures) {
        double mitjana = 0;
        for (Figura figura : figures.toArray(Figura.class)) {
            mitjana += figura.perimetre();
        }
        return mitjana / figures.mida;
    }

    public <T extends Figura> T[] arrayOrdenat(T[] t) {
        Arrays.sort(t);
        return t;
    }
}
