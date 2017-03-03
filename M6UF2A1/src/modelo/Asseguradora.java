    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@Table(name = "M6UF2_ASSEGURADORA")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Asseguradora.findAll", query = "SELECT a FROM Asseguradora a"),
//    @NamedQuery(name = "Asseguradora.findById", query = "SELECT a FROM Asseguradora a WHERE a.id = :id"),
//    @NamedQuery(name = "Asseguradora.findByNom", query = "SELECT a FROM Asseguradora a WHERE a.nom = :nom"),
//    @NamedQuery(name = "Asseguradora.findByNif", query = "SELECT a FROM Asseguradora a WHERE a.nif = :nif")})
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "NIF")
    private String nif;

    public Asseguradora() {
    }

    public Asseguradora(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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
        if (!(object instanceof Asseguradora)) {
            return false;
        }
        Asseguradora other = (Asseguradora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asseguradora[ id=" + id + " ]";
    }
    
}
