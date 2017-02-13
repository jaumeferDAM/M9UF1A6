/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoraque;


public class FiguraImpl extends Figura {

    public FiguraImpl(String nom) {
        super(nom);
    }

    public FiguraImpl() {
    }

    @Override
    public double area() {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double perimetre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Figura o) {
        if(o.area() == this.area()) {
            return 0;
        } else if (this.area() > o.area()) {
            return 1;
        }
       return -1;
    }
    
    
    
}
