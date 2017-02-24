/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */

@Entity
//@NamedQueries({
//@NamedQuery(name="PersonaNombre", query="SELECT p FROM M6UF2_PERSONES p WHERE p.nombre=:nombre")})
@Table(name = "M6UF2_PRACTICA")
public class Usuari implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "nom", length = 30)
    private String nom;

    @Column(length = 30, nullable = false)
    private String carrer;
    
    
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
