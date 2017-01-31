/*
 * Crear una classe que se li passi al constructor una instància de la classe Element i  implementi 
 * els mètodes que s'indiquen a sota. Per accedir als membres d'una instància d'una classe i  obtenir 
 * informació relacionada amb la classe,  s'ha d'utilitzar l'objecte de la classe Class obtingut amb el 
 * mètode getClass() heretat de la classe Object.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aureeeeeeeeliiiiioooooooo;

import java.util.Arrays;

/**
 *
 * @author Jaume
 */
public class Cositiiii {

    Element E;

    public Cositiiii() {
        E = new Element();
        nomClase();
        nomComplet();
        nomSimple();
        fields();
        metodes();
        atributs();
        nomMetodes();
        atribut();
    }

    /*
    * Nom de la superclase.
     */
    public void nomClase() {
        System.out.println(E.getClass().getSuperclass());
    }

    /*
    * nom de la classe complet.
     */
    public void nomComplet() {
        System.out.println(E.getClass());
    }

    /*
    * només el nom de la classe.
     */
    public void nomSimple() {
        System.out.println(E.getClass().getSimpleName());
    }

    /*
     * array d'atributs (Field).
     */
    public void fields() {
        System.out.println(Arrays.toString(E.getClass().getFields()));
    }

    /*
    * array de mètodes (Method).
     */
    public void metodes() {
        System.out.println(Arrays.toString(E.getClass().getDeclaredMethods()));
    }

    /*
    * array dels noms dels atributs.
     */
    public void atributs() {
        System.out.println(Arrays.toString(E.getClass().getDeclaredFields()));
    }

    /*
    * array dels noms dels mètodes.
     */
    public void nomMetodes() {
        System.out.println(Arrays.toString(E.getClass().getDeclaredMethods()));
    }

    /*
    * modificador d'un atribut.
     */
    public void atribut() {
        System.out.println(E.getClass().getModifiers());
    }

}
