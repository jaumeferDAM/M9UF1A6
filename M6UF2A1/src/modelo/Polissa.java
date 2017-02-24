/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@Table(name = "POLISSA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polissa.findAll", query = "SELECT p FROM Polissa p"),
    @NamedQuery(name = "Polissa.findById", query = "SELECT p FROM Polissa p WHERE p.id = :id"),
    @NamedQuery(name = "Polissa.findByNumero", query = "SELECT p FROM Polissa p WHERE p.numero = :numero"),
    @NamedQuery(name = "Polissa.findByPrenedor", query = "SELECT p FROM Polissa p WHERE p.prenedor = :prenedor"),
    @NamedQuery(name = "Polissa.findByVehicle", query = "SELECT p FROM Polissa p WHERE p.vehicle = :vehicle"),
    @NamedQuery(name = "Polissa.findByDataInici", query = "SELECT p FROM Polissa p WHERE p.dataInici = :dataInici"),
    @NamedQuery(name = "Polissa.findByDataFi", query = "SELECT p FROM Polissa p WHERE p.dataFi = :dataFi"),
    @NamedQuery(name = "Polissa.findByTipus", query = "SELECT p FROM Polissa p WHERE p.tipus = :tipus")})
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @Column(name = "PRENEDOR")
    private String prenedor;
    @Basic(optional = false)
    @Column(name = "VEHICLE")
    private String vehicle;
    @Basic(optional = false)
    @Column(name = "DATA_INICI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInici;
    @Basic(optional = false)
    @Column(name = "DATA_FI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFi;
    @Column(name = "TIPUS")
    private String tipus;

    public Polissa() {
    }

    public Polissa(String id) {
        this.id = id;
    }

    public Polissa(String id, String prenedor, String vehicle, Date dataInici, Date dataFi) {
        this.id = id;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPrenedor() {
        return prenedor;
    }

    public void setPrenedor(String prenedor) {
        this.prenedor = prenedor;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
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

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
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
        if (!(object instanceof Polissa)) {
            return false;
        }
        Polissa other = (Polissa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Polissa[ id=" + id + " ]";
    }
    
}
