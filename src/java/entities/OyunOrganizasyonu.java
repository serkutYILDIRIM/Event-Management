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
public class OyunOrganizasyonu {
    private int id;
    private String oyunAdi;
    private String oyunTuru;
    private String tarih;
    private String saat;
    private String nerede;

    public OyunOrganizasyonu() {
        this.id = 0;
        this.oyunAdi = "";
        this.oyunTuru = "";
        this.tarih = "";
        this.saat = "";
        this.nerede = "";
        
    }

    public OyunOrganizasyonu(int id, String oyunAdi, String oyunTuru, String tarih, String saat, String nerede) {
        this.id = id;
        this.oyunAdi = oyunAdi;
        this.oyunTuru = oyunTuru;
        this.tarih = tarih;
        this.saat = saat;
        this.nerede = nerede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOyunAdi() {
        return oyunAdi;
    }

    public void setOyunAdi(String oyunAdi) {
        this.oyunAdi = oyunAdi;
    }

    public String getOyunTuru() {
        return oyunTuru;
    }

    public void setOyunTuru(String oyunTuru) {
        this.oyunTuru = oyunTuru;
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

    public String getNerede() {
        return nerede;
    }

    public void setNerede(String nerede) {
        this.nerede = nerede;
    }
    
}
