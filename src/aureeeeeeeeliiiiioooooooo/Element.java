/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aureeeeeeeeliiiiioooooooo;

/**
 *
 * @author Jaume
 */
public class Element implements Cloneable{
    private int num;
    protected String cad;
    public Element(int num, String cad) {
        this.num = num;
        this.cad = cad;
    }
    public Element() {
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getCad() {
        return cad;
    }
    public void setCad(String cad) {
        this.cad = cad;
    } 
    
}
