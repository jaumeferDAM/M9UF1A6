/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
//@NamedQueries({
//@NamedQuery(name="PersonaNombre", query="SELECT p FROM M6UF2_PERSONES p WHERE p.nombre=:nombre")})
//@NamedQuery(name = Usuari.CONSULTA, query = "SELECT u FROM Usuaris u WHERE u.nom=:nom")})
@Table(name = "M6UF2_USUARI")
public class Usuari implements Serializable {

    public static final String CONSULTA = "UsuariNombre";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nom", length = 30)
    private String usuari;

    @Column(length = 30, nullable = false)
    private String password;

    public Usuari(String usuari, String password) {
        this.usuari = usuari;
        this.password = password;
    }

    public Usuari() {
    }

    public String getNom() {
        return usuari;
    }

    public void setNom(String nom) {
        this.usuari = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.usuari);
        hash = 47 * hash + Objects.hashCode(this.password);
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
        final Usuari other = (Usuari) obj;
        if (!Objects.equals(this.usuari, other.usuari)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuari{" + "usuari=" + usuari + ", password=" + password + '}';
    }

    

}
