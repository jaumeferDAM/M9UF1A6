/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
    private String id;
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "ANYFABRICACIO")
    private BigInteger anyfabricacio;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente propietari;
    @Column(name = "MARCA")
    private String marca;

    public Vehicles() {
    }

    public Vehicles(String id) {
        this.id = id;
    }

    public Vehicles(String id, String matricula) {
        this.id = id;
        this.matricula = matricula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public BigInteger getAnyfabricacio() {
        return anyfabricacio;
    }

    public void setAnyfabricacio(BigInteger anyfabricacio) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicles)) {
            return false;
        }
        Vehicles other = (Vehicles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vehicles[ id=" + id + " ]";
    }
    
}
