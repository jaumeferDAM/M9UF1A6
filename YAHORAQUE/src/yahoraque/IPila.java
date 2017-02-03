/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoraque;



/**
 *
 * @author ALUMNEDAM
 * @param <T>
 */
public interface IPila<T> {
            class Node<T> {
        Node pare;
        T t;

        public Node(Node pare, T t) {
            this.pare = pare;
            this.t = t;
        }
        }

    /**
     *
     * @param valor
     */
     void afegir(int valor);
     
     T treure();
     
     void buidar();
     
     int getMida();
     
     T[] toArray(Class<T> t);
    }

