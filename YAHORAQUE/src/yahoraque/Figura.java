/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoraque;

/**
 *
 * @author ALUMNEDAM
 */
public abstract class Figura {

    private String nom;

    public Figura(String nom) {
        this.nom = nom;
    }

    public Figura(){};

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract double area();

    public abstract double perimetre();
}
