/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Serkut
 */
public class DugunOrganizasyonu {
    private int id;
    private String dugunCesidi;
    private String dugunYeri;
    private String tarih;
    private String saat;

    public DugunOrganizasyonu() {
        this.id=0;
        this.dugunCesidi="";
        this.dugunYeri="";
        this.tarih="";
        this.saat="";
    }

    public DugunOrganizasyonu(int id, String dugunCesidi, String dugunYeri, String tarih, String saat) {
        this.id = id;
        this.dugunCesidi = dugunCesidi;
        this.dugunYeri = dugunYeri;
        this.tarih = tarih;
        this.saat = saat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDugunCesidi() {
        return dugunCesidi;
    }

    public void setDugunCesidi(String dugunCesidi) {
        this.dugunCesidi = dugunCesidi;
    }

    public String getDugunYeri() {
        return dugunYeri;
    }

    public void setDugunYeri(String dugunYeri) {
        this.dugunYeri = dugunYeri;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }
    
}
