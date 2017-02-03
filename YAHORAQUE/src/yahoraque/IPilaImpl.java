/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoraque;

import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IPilaImpl<T> implements IPila<T> {

    Node NodeActual = null;
    int mida = 0;

    /*
    * Afegeix un node a la pila de objectes, aumentant la mida d'aquesta en 1.
    */
    @Override
    public void afegir(int valor) {
        NodeActual = new Node(NodeActual, valor);
        mida++;
    }

    @Override
    public T treure() {
        T valorAux = null;
        if (NodeActual != null) {
            valorAux = (T) NodeActual.t;
            NodeActual = NodeActual.pare;
            mida--;
        } else {
            try {
                throw new Exception("Pila buida");
            } catch (Exception ex) {
                Logger.getLogger(IPilaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valorAux;
    }

    @Override
    public void buidar() {
        NodeActual = null;
        mida = 0;
    }

    @Override
    public int getMida() {
        return mida;
    }

    @Override
    public T[] toArray(Class<T> t) {
        T[] llista = (T[]) Array.newInstance(t, mida);
        int x = mida;
        Node aux = NodeActual;
        while (aux != null) {
            llista[x-1] = (T) aux.t;
            aux = aux.pare;
        }
        return llista;
    }

}
