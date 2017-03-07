/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@Table(name = "M6UF2_VEHICLES")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Vehicles.findAll", query = "SELECT v FROM Vehicles v"),
//    @NamedQuery(name = "Vehicles.findById", query = "SELECT v FROM Vehicles v WHERE v.id = :id"),
//    @NamedQuery(name = "Vehicles.findByModel", query = "SELECT v FROM Vehicles v WHERE v.model = :model"),
//    @NamedQuery(name = "Vehicles.findByMatricula", query = "SELECT v FROM Vehicles v WHERE v.matricula = :matricula"),
//    @NamedQuery(name = "Vehicles.findByAnyfabricacio", query = "SELECT v FROM Vehicles v WHERE v.anyfabricacio = :anyfabricacio"),
//    @NamedQuery(name = "Vehicles.findByPropietari", query = "SELECT v FROM Vehicles v WHERE v.propietari = :propietari"),
//    @NamedQuery(name = "Vehicles.findByMarca", query = "SELECT v FROM Vehicles v WHERE v.marca = :marca")})
public class Vehicles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "ANYFABRICACIO")
    private int anyfabricacio;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente propietari;
    @Column(name = "MARCA")
    private String marca;
    @OneToOne
    @JoinColumn(name = "POLISSA")
    private Polissa polissa;

    public Vehicles(int id, String model, String matricula, int anyfabricacio, Cliente propietari, String marca, Polissa polissa) {
        this.id = id;
        this.model = model;
        this.matricula = matricula;
        this.anyfabricacio = anyfabricacio;
        this.propietari = propietari;
        this.marca = marca;
        this.polissa = polissa;
    }

    public Polissa getPolissa() {
        return polissa;
    }

    public void setPolissa(Polissa polissa) {
        this.polissa = polissa;
    }

    
    
    public Vehicles() {
    }

    public Vehicles(int id) {
        this.id = id;
    }

    public Vehicles(int id, String matricula) {
        this.id = id;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnyfabricacio() {
        return anyfabricacio;
    }

    public void setAnyfabricacio(int anyfabricacio) {
        this.anyfabricacio = anyfabricacio;
    }

    public Cliente getPropietari() {
        return propietari;
    }

    public void setPropietari(Cliente propietari) {
        this.propietari = propietari;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicles other = (Vehicles) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicles{" + "id=" + id + ", model=" + model + ", matricula=" + matricula + ", anyfabricacio=" + anyfabricacio + ", propietari=" + propietari + ", marca=" + marca + ", polissa=" + polissa + '}';
    }

    
}
