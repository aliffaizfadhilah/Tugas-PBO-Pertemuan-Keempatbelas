/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kontainer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alif
 */
@Entity
@Table(name = "pw")
@NamedQueries({
    @NamedQuery(name = "Pw.findAll", query = "SELECT p FROM Pw p"),
    @NamedQuery(name = "Pw.findByUsername", query = "SELECT p FROM Pw p WHERE p.username = :username"),
    @NamedQuery(name = "Pw.findByPassword", query = "SELECT p FROM Pw p WHERE p.password = :password"),
    @NamedQuery(name = "Pw.findByHobi", query = "SELECT p FROM Pw p WHERE p.hobi = :hobi")})
public class Pw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "hobi")
    private String hobi;

    public Pw() {
    }

    public Pw(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pw)) {
            return false;
        }
        Pw other = (Pw) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kontainer.Pw[ username=" + username + " ]";
    }
    
}
