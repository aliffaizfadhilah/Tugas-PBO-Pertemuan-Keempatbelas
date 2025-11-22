/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kontainer;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alif
 */
@Entity
@Table(name = "pemilik")
@NamedQueries({
    @NamedQuery(name = "Pemilik.findAll", query = "SELECT p FROM Pemilik p"),
    @NamedQuery(name = "Pemilik.findByIdPemilik", query = "SELECT p FROM Pemilik p WHERE p.idPemilik = :idPemilik"),
    @NamedQuery(name = "Pemilik.findByNamaPemilik", query = "SELECT p FROM Pemilik p WHERE p.namaPemilik = :namaPemilik"),
    @NamedQuery(name = "Pemilik.findByAlamat", query = "SELECT p FROM Pemilik p WHERE p.alamat = :alamat"),
    @NamedQuery(name = "Pemilik.findByNoTelepon", query = "SELECT p FROM Pemilik p WHERE p.noTelepon = :noTelepon")})
public class Pemilik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pemilik")
    private String idPemilik;
    @Column(name = "nama_pemilik")
    private String namaPemilik;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "no_telepon")
    private String noTelepon;
    @OneToMany(mappedBy = "idPemilik")
    private Collection<Petville> petvilleCollection;

    public Pemilik() {
    }

    public Pemilik(String idPemilik) {
        this.idPemilik = idPemilik;
    }

    public String getIdPemilik() {
        return idPemilik;
    }

    public void setIdPemilik(String idPemilik) {
        this.idPemilik = idPemilik;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public Collection<Petville> getPetvilleCollection() {
        return petvilleCollection;
    }

    public void setPetvilleCollection(Collection<Petville> petvilleCollection) {
        this.petvilleCollection = petvilleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPemilik != null ? idPemilik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pemilik)) {
            return false;
        }
        Pemilik other = (Pemilik) object;
        if ((this.idPemilik == null && other.idPemilik != null) || (this.idPemilik != null && !this.idPemilik.equals(other.idPemilik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kontainer.Pemilik[ idPemilik=" + idPemilik + " ]";
    }
    
}
