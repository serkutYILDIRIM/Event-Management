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
public class FilmOrganizasyonu {
    private int id;
    private String filmAdi;
    private String tarih;
    private String saat;
    private String gosterimYeri;
    private String yonetmen;
    private String basrolOyunculari;
    public FilmOrganizasyonu() {
        this.id=0;
        this.filmAdi= "";
        this.tarih="";
        this.saat="";
        this.gosterimYeri="";
        this.yonetmen="";
        this.basrolOyunculari="";
    }

    public FilmOrganizasyonu(int id, String filmAdi, String tarih, String saat, String gosterimYeri, String yonetmen, String basrolOyunculari) {
        this.id = id;
        this.filmAdi = filmAdi;
        this.tarih = tarih;
        this.saat = saat;
        this.gosterimYeri = gosterimYeri;
        this.yonetmen = yonetmen;
        this.basrolOyunculari = basrolOyunculari;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
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

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    public String getBasrolOyunculari() {
        return basrolOyunculari;
    }

    public void setBasrolOyunculari(String basrolOyunculari) {
        this.basrolOyunculari = basrolOyunculari;
    }
    
    
}
