/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Darkshan
 */

@Table(name="undangan")
@Entity
public class Undangan implements Serializable {
    @Id @GeneratedValue
    @Column(name="id_undangan",unique=true)
    private int id_undangan;
    @Column(name="p_pria")
    private String p_pria;
    @Column(name="p_wanita")
    private String p_wanita;
    @Column(name="alamat")
    private String alamat;
    @Column(name="mengundang")
    private String mengundang;
    @Column(name="jadwal")
    private LocalDateTime jadwal;

    public Undangan() {
    }

   public Undangan( String p_pria, String p_wanita, String alamat, String mengundang, LocalDateTime jadwal) {
        
        this.p_pria = p_pria;
        this.p_wanita = p_wanita;
        this.alamat = alamat;
        this.mengundang = mengundang;
        this.jadwal = jadwal;
    }

    public Undangan(int id_undangan, String p_pria, String p_wanita, String alamat, String mengundang, LocalDateTime jadwal) {
        this.id_undangan = id_undangan;
        this.p_pria = p_pria;
        this.p_wanita = p_wanita;
        this.alamat = alamat;
        this.mengundang = mengundang;
        this.jadwal = jadwal;
    }

    public int getId_undangan() {
        return id_undangan;
    }

    public void setId_undangan(int id_undangan) {
        this.id_undangan = id_undangan;
    }

    public String getP_pria() {
        return p_pria;
    }

    public void setP_pria(String p_pria) {
        this.p_pria = p_pria;
    }

    public String getP_wanita() {
        return p_wanita;
    }

    public void setP_wanita(String p_wanita) {
        this.p_wanita = p_wanita;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMengundang() {
        return mengundang;
    }

    public void setMengundang(String mengundang) {
        this.mengundang = mengundang;
    }

    public LocalDateTime getJadwal() {
        return jadwal;
    }

    public void setJadwal(LocalDateTime jadwal) {
        this.jadwal = jadwal;
    }

    @Override
    public String toString() {
        return "Undangan [id_undangan="+this.id_undangan+",p_pria="+this.p_pria+",p_wanita="+this.p_wanita+",alamat="+this.alamat+",jadwal="+this.jadwal+",mengundang="+this.mengundang+"]"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
