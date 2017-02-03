/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoraque;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ALUMNEDAM
 * @param <T>
 */
public final class InfoClaseGenerica<T extends Figura> {


    //Atribut Class de tipus parametritzat, inicialitzat al constructor
    private final Class<T> ct;

    //Constructor
    public InfoClaseGenerica(Class<T> ct) throws InstantiationException, IllegalAccessException {
        this.ct = ct;
        superClasse();
        nomClasseComplet();
        nomClasse();
        Atributs();
        Metodes();
        NomAtributs();
        nomMetodes();
        instanciaGenericca();

    }

    /*
    * Torna un string amb el nom de la superclase.
    */
    public String superClasse() {

        return ct.getClass().getSuperclass().getName();
    }

    /*
    * Torna un string amb el nom de la clase complet.
    */
    public String nomClasseComplet() {
        System.out.println(ct.getClass().getName());
        return ct.getClass().getName();
    }
    
    /*
    * Torna un string amb el nom de la clase.
    */
    public String nomClasse() {

        return ct.getName();
    }

    /*
    * Torna un array de fields amb els atributs declarats de la clase.
    */
    public Field[] Atributs() {
        System.out.println(Arrays.toString(ct.getDeclaredFields()));
        return ct.getDeclaredFields();
    }

    /*
    * Torna un array de method amb els metodes declarats de la clase.
    */
    public Method[] Metodes() {
        System.out.println(Arrays.toString(ct.getMethods()));
        return ct.getClass().getMethods();
    }

    /*
    * Torna un array amb el nom dels atributs declarats de la clase.
    */
    public ArrayList NomAtributs() {
        ArrayList nomAt = new ArrayList();
        Field[] att = Atributs();
        for (int i = 0; i < nomAt.size(); i++) {
            nomAt.add(att[i].getName());
        }
        return nomAt;
    }

    /*
    * Torna un array amb el nom dels metodes declarats de la clase.
    */
    public ArrayList nomMetodes() {
        ArrayList nomMet = new ArrayList();
        Method[] met = Metodes();
        for (int i = 0; i < nomMet.size(); i++) {
            nomMet.add(met[i].getName());
        }
        return nomMet;
    }
    
    /*
    * Torna una nova instancia de la clase en forma de dada generica.
    */
    public T instanciaGenericca() throws InstantiationException, IllegalAccessException {
        return ct.newInstance();
    }

    /*
    * Torna l'objecte clonat.
    */
    public Object clone(Object O) throws CloneNotSupportedException {
        //TODO
        Object x = O;
        return x;
    }
}
