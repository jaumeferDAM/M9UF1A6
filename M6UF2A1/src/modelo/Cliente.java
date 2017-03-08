/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@Table(name = "M6UF2_CLIENTE")
//@NamedQueries({
//    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
//    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
//    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
//    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private int idCliente;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Embedded
    private Adreca adreca;
    @OneToMany(mappedBy = "propietari")
    private List<Vehicles> vehicles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLISSA_ID")
    private Polissa polissa;

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

 

   


    
    
    
    public Adreca getAdreca() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    public Cliente(Short idCliente, String nombre, Long telefono, Adreca adreca) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.adreca = adreca;
    }

    public Cliente(int idCliente, String nombre, Long telefono, Adreca adreca, ArrayList<Vehicles> vehicles) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.adreca = adreca;
        this.vehicles = vehicles;
    }
    
    
    public Cliente() {
    }

    public Cliente(Short idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public Polissa getPolissa() {
        return polissa;
    }

    public void setPolissa(Polissa polissa) {
        this.polissa = polissa;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idCliente;
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", telefono=" + telefono + ", adreca=" + adreca + ", vehicles=" + vehicles + '}';
    }

    
    
}
