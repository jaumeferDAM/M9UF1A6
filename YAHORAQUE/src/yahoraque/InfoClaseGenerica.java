/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoraque;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author ALUMNEDAM
 * @param <T>
 */
public final class InfoClaseGenerica<T extends Figura> {

    private T[] cositas;

    //Atribut Class de tipus parametritzat, inicialitzat al constructor
    private final Class<T> ct;

    //Constructor
    public InfoClaseGenerica(Class<T> ct) {
        this.ct = ct;
        superClasse();
        nomClasseComplet();
        nomClasse();
        nomAtributs();
        nomMetodes();
    }

    public String superClasse() {
      
        return ct.getClass().getSuperclass().getName();
    }
    
    public String nomClasseComplet() {
        System.out.println(ct.getClass().getName());
        return ct.getClass().getName();
    }
    public String nomClasse() {
        
        return ct.getName();
    }
    
    public Field[] nomAtributs() {
        System.out.println(Arrays.toString(ct.getDeclaredFields()));
        return ct.getDeclaredFields();
    }
    
    public Method[] nomMetodes() {
        System.out.println(Arrays.toString(ct.getMethods()));
        return ct.getClass().getMethods();
    }
    

}
