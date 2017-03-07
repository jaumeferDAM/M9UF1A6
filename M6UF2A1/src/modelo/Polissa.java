/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@Table(name = "M6UF2_POLISSA")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Polissa.findAll", query = "SELECT p FROM Polissa p"),
//    @NamedQuery(name = "Polissa.findById", query = "SELECT p FROM Polissa p WHERE p.id = :id"),
//    @NamedQuery(name = "Polissa.findByNumero", query = "SELECT p FROM Polissa p WHERE p.numero = :numero"),
//    @NamedQuery(name = "Polissa.findByPrenedor", query = "SELECT p FROM Polissa p WHERE p.prenedor = :prenedor"),
//    @NamedQuery(name = "Polissa.findByVehicle", query = "SELECT p FROM Polissa p WHERE p.vehicle = :vehicle"),
//    @NamedQuery(name = "Polissa.findByDataInici", query = "SELECT p FROM Polissa p WHERE p.dataInici = :dataInici"),
//    @NamedQuery(name = "Polissa.findByDataFi", query = "SELECT p FROM Polissa p WHERE p.dataFi = :dataFi"),
//    @NamedQuery(name = "Polissa.findByTipus", query = "SELECT p FROM Polissa p WHERE p.tipus = :tipus")})
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente prenedor;
    @Basic(optional = false)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VEHICLE")
    private Vehicles vehicle;
    @Basic(optional = false)
    @Column(name = "DATA_INICI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInici;
    @Basic(optional = false)
    @Column(name = "DATA_FI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFi;
    @Column(name = "TIPUS")
    private Enum tipus;
    @Column(name = "PRIMA")
    private float prima;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ASSEGURADORAID")
    private Asseguradora asseguradora;
    

    public Polissa() {
    }

    public Polissa(int id) {
        this.id = id;
    }

    public Polissa(int id, Cliente prenedor, Vehicles vehicle, Date dataInici, Date dataFi) {
        this.id = id;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Polissa(int id, String numero, Cliente prenedor, Vehicles vehicle, Date dataInici, Date dataFi, Enum tipus, float prima) {
        this.id = id;
        this.numero = numero;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getPrenedor() {
        return prenedor;
    }

    public float getPrima() {
        return prima;
    }

    public void setPrima(float prima) {
        this.prima = prima;
    }

    public void setPrenedor(Cliente prenedor) {
        this.prenedor = prenedor;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public Enum getTipus() {
        return tipus;
    }

    public void setTipus(Enum tipus) {
        this.tipus = tipus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
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
        final Polissa other = (Polissa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "id=" + id + ", numero=" + numero + ", prenedor=" + prenedor + ", vehicle=" + vehicle + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipus=" + tipus + ", prima=" + prima + '}';
    }

    
}
