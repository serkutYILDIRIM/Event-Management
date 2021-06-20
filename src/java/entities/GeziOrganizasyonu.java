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
public class GeziOrganizasyonu {
    private int id;
    private String gidilecekYer;
    private String hareketYeri;
    private String tarih;
    private String saat;

    public GeziOrganizasyonu() {
        this.id=0;
        this.gidilecekYer="";
        this.hareketYeri="";
        this.tarih="";
        this.saat="";
    }

    public GeziOrganizasyonu(int id, String gidilecekYer, String hareketYeri, String tarih, String saat) {
        this.id = id;
        this.gidilecekYer = gidilecekYer;
        this.hareketYeri = hareketYeri;
        this.tarih = tarih;
        this.saat = saat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGidilecekYer() {
        return gidilecekYer;
    }

    public void setGidilecekYer(String gidilecekYer) {
        this.gidilecekYer = gidilecekYer;
    }

    public String getHareketYeri() {
        return hareketYeri;
    }

    public void setHareketYeri(String hareketYeri) {
        this.hareketYeri = hareketYeri;
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
