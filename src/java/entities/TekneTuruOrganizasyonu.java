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
public class TekneTuruOrganizasyonu {
    private int id;
    private String hareketYeri;
    private String bitisNoktasi;
    private String turCesidi;
    private String yemek;
    private String fiyat;

    public TekneTuruOrganizasyonu() {
        this.id = 0;
        this.hareketYeri = "";
        this.bitisNoktasi = "";
        this.turCesidi = "";
        this.yemek = "";
        this.fiyat = "";
    }

    public TekneTuruOrganizasyonu(int id, String hareketYeri, String bitisNoktasi, String turCesidi, String yemek, String fiyat) {
        this.id = id;
        this.hareketYeri = hareketYeri;
        this.bitisNoktasi = bitisNoktasi;
        this.turCesidi = turCesidi;
        this.yemek = yemek;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHareketYeri() {
        return hareketYeri;
    }

    public void setHareketYeri(String hareketYeri) {
        this.hareketYeri = hareketYeri;
    }

    public String getBitisNoktasi() {
        return bitisNoktasi;
    }

    public void setBitisNoktasi(String bitisNoktasi) {
        this.bitisNoktasi = bitisNoktasi;
    }

    public String getTurCesidi() {
        return turCesidi;
    }

    public void setTurCesidi(String turCesidi) {
        this.turCesidi = turCesidi;
    }

    public String getYemek() {
        return yemek;
    }

    public void setYemek(String yemek) {
        this.yemek = yemek;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }
    
}
