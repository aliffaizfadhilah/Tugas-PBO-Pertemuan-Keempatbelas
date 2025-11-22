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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alif
 */
@Entity
@Table(name = "petville")
@NamedQueries({
    @NamedQuery(name = "Petville.findAll", query = "SELECT p FROM Petville p"),
    @NamedQuery(name = "Petville.findByIdHewan", query = "SELECT p FROM Petville p WHERE p.idHewan = :idHewan"),
    @NamedQuery(name = "Petville.findByNamaHewan", query = "SELECT p FROM Petville p WHERE p.namaHewan = :namaHewan"),
    @NamedQuery(name = "Petville.findByJenisHewan", query = "SELECT p FROM Petville p WHERE p.jenisHewan = :jenisHewan"),
    @NamedQuery(name = "Petville.findByHarga", query = "SELECT p FROM Petville p WHERE p.harga = :harga")})
public class Petville implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_hewan")
    private String idHewan;
    @Column(name = "nama_hewan")
    private String namaHewan;
    @Column(name = "jenis_hewan")
    private String jenisHewan;
    @Column(name = "harga")
    private Integer harga;
    @JoinColumn(name = "id_pemilik", referencedColumnName = "id_pemilik")
    @ManyToOne
    private Pemilik idPemilik;

    public Petville() {
    }

    public Petville(String idHewan) {
        this.idHewan = idHewan;
    }

    public String getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(String idHewan) {
        this.idHewan = idHewan;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    public String getJenisHewan() {
        return jenisHewan;
    }

    public void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Pemilik getIdPemilik() {
        return idPemilik;
    }

    public void setIdPemilik(Pemilik idPemilik) {
        this.idPemilik = idPemilik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHewan != null ? idHewan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Petville)) {
            return false;
        }
        Petville other = (Petville) object;
        if ((this.idHewan == null && other.idHewan != null) || (this.idHewan != null && !this.idHewan.equals(other.idHewan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kontainer.Petville[ idHewan=" + idHewan + " ]";
    }
    
}
