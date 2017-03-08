    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    private int id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "NIF")
    private String nif;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Polissa")
    private List<Polissa> polissa;

    public Asseguradora(int id, String nom, String nif) {
        this.id = id;
        this.nom = nom;
        this.nif = nif;
    }

    public List<Polissa> getPolissa() {
        return polissa;
    }

    public void setPolissa(List<Polissa> polissa) {
        this.polissa = polissa;
    }

    
    
    

    public Asseguradora() {
    }

    public Asseguradora(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Asseguradora other = (Asseguradora) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "id=" + id + ", nom=" + nom + ", nif=" + nif + ", polissa=" + polissa + '}';
    }

    
    
}
