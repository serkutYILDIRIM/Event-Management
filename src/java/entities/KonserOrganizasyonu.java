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
public class KonserOrganizasyonu {
    private int id;
    private String konserAdi;
    private String tarih;
    private String saat;
    private String gosterimYeri;
    private String kiminKonseri;

    public KonserOrganizasyonu() {
        this.id=0;
        this.konserAdi="";
        this.tarih="";
        this.saat="";
        this.gosterimYeri="";
        this.kiminKonseri="";
        
    }    

    public KonserOrganizasyonu(int id, String konserAdi, String tarih, String saat, String gosterimYeri, String kiminKonseri) {
        this.id = id;
        this.konserAdi = konserAdi;
        this.tarih = tarih;
        this.saat = saat;
        this.gosterimYeri = gosterimYeri;
        this.kiminKonseri = kiminKonseri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKonserAdi() {
        return konserAdi;
    }

    public void setKonserAdi(String konserAdi) {
        this.konserAdi = konserAdi;
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

    public String getGosterimYeri() {
        return gosterimYeri;
    }

    public void setGosterimYeri(String gosterimYeri) {
        this.gosterimYeri = gosterimYeri;
    }

    public String getKiminKonseri() {
        return kiminKonseri;
    }

    public void setKiminKonseri(String kiminKonseri) {
        this.kiminKonseri = kiminKonseri;
    }
    
}
